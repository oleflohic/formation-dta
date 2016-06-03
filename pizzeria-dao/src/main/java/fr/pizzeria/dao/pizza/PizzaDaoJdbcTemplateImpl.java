package fr.pizzeria.dao.pizza;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import fr.pizzeria.exception.dao.AjouterPizzaException;
import fr.pizzeria.exception.dao.ModifierPizzaException;
import fr.pizzeria.exception.dao.SupprimerPizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

@Repository
@Lazy
public class PizzaDaoJdbcTemplateImpl implements IPizzaDao {

	private JdbcTemplate jdbcTemplate;
	private TransactionTemplate txTemplate;
	
	//@Autowired private BatchPizzaDaoJdbcTemplate batchPizzaDaoJdbcTemplate;
	
	@Autowired
	public PizzaDaoJdbcTemplateImpl (DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.txTemplate = new TransactionTemplate();
		System.out.println("Création du bean PizzaDaoJdbcTemplate");
	}
	
	
	@Override
	public List<Pizza> listePizzas() {
		return jdbcTemplate.query(
				"SELECT * FROM pizza",
				(rs, rowNum) ->
					new Pizza(
						rs.getString("code"),
						rs.getString("nom"),
						rs.getBigDecimal("prix"),
						CategoriePizza.valueOf(rs.getString("categorie")),
						rs.getString("url_image")
					)
			);
	}

	@Override
	public void ajouterPizza(Pizza nouvellePizza) throws AjouterPizzaException {

		// code de longueur invalide : exception
		if (nouvellePizza.getCode().length() != 3) {
			throw new AjouterPizzaException ("Le code pizza " + nouvellePizza.getCode() + " est de longueur invalide (doit contenir 3 caractères).");
		}
		
		try {
			jdbcTemplate.update("INSERT INTO pizza (code,nom,prix,categorie,url_image) VALUES(?,?,?,?,?)",
				nouvellePizza.getCode(), nouvellePizza.getNom(), nouvellePizza.getPrix(), nouvellePizza.getCategorie().name(), nouvellePizza.getUrlImage());
		} catch (DuplicateKeyException e) {
			throw new AjouterPizzaException("Erreur : le code pizza " + nouvellePizza.getCode() + " est déjà pris.");
		}
	}

	@Override
	public void modifierPizza(String codePizza, Pizza pizzaModifiee) throws ModifierPizzaException {
		try {
			
			if (pizzaModifiee.getCode().length() != 3) {
				throw new ModifierPizzaException ("Le code pizza " + pizzaModifiee.getCode() + " est de longueur invalide (doit contenir 3 caractères).");
			}
			
			int count = jdbcTemplate.update("UPDATE pizza SET code=?, nom=?, prix=?, categorie=?, url_image=? WHERE code=?",
					pizzaModifiee.getCode(), pizzaModifiee.getNom(), pizzaModifiee.getPrix(), pizzaModifiee.getCategorie().name(), pizzaModifiee.getUrlImage(), codePizza);
			if (count < 1) {
				throw new ModifierPizzaException("Erreur : code pizza '" + codePizza + "' introuvable.");
			}
		} catch (DuplicateKeyException e) {
			throw new ModifierPizzaException("Erreur : le code pizza " + pizzaModifiee.getCode() + " est déjà pris.");
		}
		
	}

	@Override
	public void supprimerPizza(String codePizza) throws SupprimerPizzaException {
		int count = jdbcTemplate.update("DELETE FROM pizza WHERE code=?", codePizza);
		if (count < 1) {
			throw new SupprimerPizzaException("Erreur : code pizza '" + codePizza + "' introuvable.");
		}
	}

	@Override
	public boolean codePizzaExiste(String codePizza) {
		//return !jdbcTemplate.query("SELECT TOP 1 code FROM pizza WHERE code=" + codePizza, (rs, rowNum) -> { return rs.getString("code"); }).isEmpty();
		
		throw new UnsupportedOperationException();
	}

	@Override
	public Pizza trouverPizza(String codePizza) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void ajouterGroupePizzas(List<Pizza> pizzasAInserer) {
		
		this.txTemplate.execute(status -> {
			pizzasAInserer.forEach(t -> {
				try {
					ajouterPizza(t);
				} catch (AjouterPizzaException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			return null;
		});
		
	}
	
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void ajouterPizzaTransactional(List<Pizza> listePizzas) {
		listePizzas.forEach(p -> {
			try {
				ajouterPizza(p);
			} catch (AjouterPizzaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}

}
