package fr.pizzeria.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import fr.pizzeria.exception.dao.AjouterPizzaException;
import fr.pizzeria.exception.dao.ModifierPizzaException;
import fr.pizzeria.exception.dao.SupprimerPizzaException;
import fr.pizzeria.model.Pizza;

public class PizzaDaoJpa implements IPizzaDao {

	// ==== Variables ====
	
	/**
	 * 
	 */
	private EntityManagerFactory entityManagerFactory;
	

	// ==== Constructeurs ====
	public PizzaDaoJpa (EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}
	
	// ==== Méthodes ====
	
	@Override
	public List<Pizza> listePizzas() {
		// TODO Auto-generated method stub
		
		/*
		EntityManager manager = entityManagerFactory.createEntityManager();
		Query query = manager.createQuery("SELECT * FROM pizza");
		List results = query.getResultList();
		*/
		
		return null;
	}

	@Override
	public void ajouterPizza(Pizza pizzaAjoutee) throws AjouterPizzaException {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifierPizza(String codePizza, Pizza pizzaModifiee) throws ModifierPizzaException {
		// TODO Auto-generated method stub

	}

	@Override
	public void supprimerPizza(String codePizza) throws SupprimerPizzaException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean codePizzaExiste(String codePizza) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Pizza trouverPizza(String codePizza) {
		// TODO Auto-generated method stub
		return null;
	}

}
