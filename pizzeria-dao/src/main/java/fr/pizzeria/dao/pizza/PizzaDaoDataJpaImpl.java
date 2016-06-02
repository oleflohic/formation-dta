package fr.pizzeria.dao.pizza;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.pizzeria.exception.dao.AjouterPizzaException;
import fr.pizzeria.exception.dao.ModifierPizzaException;
import fr.pizzeria.exception.dao.SupprimerPizzaException;
import fr.pizzeria.model.Pizza;

@Repository
@Lazy
public class PizzaDaoDataJpaImpl implements IPizzaDao {
	
	@Autowired
	private IPizzaRepository repository;
	
	
	@Override
	@Transactional
	public List<Pizza> listePizzas() {
		return repository.findAll();
	}

	@Override
	@Transactional
	public void ajouterPizza(Pizza pizzaAjoutee) throws AjouterPizzaException {
		
		try {
			repository.saveAndFlush(pizzaAjoutee);
		} catch (JpaSystemException e) {
			throw new AjouterPizzaException("code pris?");
			//System.out.println("EXCEPTION : " + e);
		}
		
		//System.out.println("P = " + p);
		
		//throw new UnsupportedOperationException();
	}

	@Override
	@Transactional
	public void modifierPizza(String codePizza, Pizza pizzaModifiee) throws ModifierPizzaException {
		throw new UnsupportedOperationException();
	}

	@Override
	@Transactional
	public void supprimerPizza(String codePizza) throws SupprimerPizzaException {
		throw new UnsupportedOperationException();
	}

	@Override
	@Transactional
	public boolean codePizzaExiste(String codePizza) {
		throw new UnsupportedOperationException();
	}

	@Override
	@Transactional
	public Pizza trouverPizza(String codePizza) {
		throw new UnsupportedOperationException();
	}

	@Override
	@Transactional
	public void ajouterGroupePizzas(List<Pizza> pizzasAInserer) {
		throw new UnsupportedOperationException();
	}

}
