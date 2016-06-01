package fr.pizzeria.dao.pizza;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
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
	public void ajouterPizza(Pizza pizzaAjoutee) throws AjouterPizzaException {
		// TODO Auto-generated method stub
		//throw new UnsupportedOperationException();
		
		jdbcTemplate.update("INSERT INTO pizza (code,nom,prix,categorie,url_image) VALUES(?,?,?,?,?)",
				pizzaAjoutee.getCode(), pizzaAjoutee.getNom(), pizzaAjoutee.getPrix(), pizzaAjoutee.getCategorie().name(), pizzaAjoutee.getUrlImage());
	}

	@Override
	public void modifierPizza(String codePizza, Pizza pizzaModifiee) throws ModifierPizzaException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public void supprimerPizza(String codePizza) throws SupprimerPizzaException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean codePizzaExiste(String codePizza) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public Pizza trouverPizza(String codePizza) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public void ajouterGroupePizzas(List<Pizza> pizzasAInserer) {
		// TODO Auto-generated method stub
		
		
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
		
		
		/*
		this.txTemplate.execute(new TransactionCallback<Pizza>() {
			@Override
			public Pizza doInTransaction(TransactionStatus status) {
				return null;
			}
		});
		*/
		
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
