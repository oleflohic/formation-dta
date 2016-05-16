package fr.pizzeria.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import fr.pizzeria.exception.dao.AjouterPizzaException;
import fr.pizzeria.exception.dao.ModifierPizzaException;
import fr.pizzeria.exception.dao.SupprimerPizzaException;
import fr.pizzeria.model.Pizza;

public class PizzaDaoJpaImpl implements IPizzaDao {

	// ==== Variables ====
	
	/**
	 * 
	 */
	private EntityManagerFactory entityManagerFactory;
	
	
	// ==== Constructeurs ====
	public PizzaDaoJpaImpl (EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}
	
	// ==== Méthodes ====
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Pizza> listePizzas() {
		EntityManager manager = entityManagerFactory.createEntityManager();
		Query query = manager.createQuery("SELECT id,code,libelle,prix,type FROM pizza");
		
		//List<Pizza> result = (List<Pizza>) manager.createQuery("from Pizza").getResultList();
		
		manager.close();
		return (List<Pizza>)query.getResultList();
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
