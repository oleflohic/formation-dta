package fr.pizzeria.dao.pizza;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import fr.pizzeria.exception.dao.AjouterPizzaException;
import fr.pizzeria.exception.dao.ModifierPizzaException;
import fr.pizzeria.exception.dao.SupprimerPizzaException;
import fr.pizzeria.model.Pizza;

@Named
@ApplicationScoped
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
	
	@Override
	public List<Pizza> listePizzas() {
		EntityManager em = entityManagerFactory.createEntityManager();
		List<Pizza> resultat = em.createQuery("SELECT p FROM Pizza p", Pizza.class).getResultList();
		em.close();
		return resultat;
	}
	
	@Override
	public void ajouterPizza(Pizza pizzaAjoutee) throws AjouterPizzaException {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		try {
			em.persist(pizzaAjoutee);
			em.getTransaction().commit();
			em.close();
		} catch (PersistenceException e) {
			em.close();
			//e.printStackTrace();
			throw new AjouterPizzaException("Le code \"" + pizzaAjoutee.getCode() + "\" est déjà pris.");
		}
	}
	
	@Override
	public void modifierPizza(String codePizza, Pizza pizzaModifiee) throws ModifierPizzaException {
		EntityManager em = entityManagerFactory.createEntityManager();
		
		em.getTransaction().begin();
		
		TypedQuery<Pizza> query = em.createQuery("SELECT p FROM Pizza p WHERE p.code=:codePizza", Pizza.class);
		query.setParameter("codePizza", codePizza);
		Pizza pizza = query.getSingleResult();
		
		pizza.setCode(pizzaModifiee.getCode());
		pizza.setNom(pizzaModifiee.getNom());
		pizza.setPrix(pizzaModifiee.getPrix());
		pizza.setCategorie(pizzaModifiee.getCategorie());

		em.getTransaction().commit();
		
		em.close();
	}
	
	@Override
	public void supprimerPizza(String codePizza) throws SupprimerPizzaException {
		EntityManager em = entityManagerFactory.createEntityManager();
		
		em.getTransaction().begin();
		TypedQuery<Pizza> query = em.createQuery("SELECT p FROM Pizza p WHERE p.code=:codePizza", Pizza.class);
		query.setParameter("codePizza", codePizza);
		try {
			em.remove(query.getSingleResult());
			em.getTransaction().commit();
			em.close();
		} catch (NoResultException e) {
			throw new SupprimerPizzaException("Code pizza inconnu.");
		}
	}
	
	@Override
	public boolean codePizzaExiste(String codePizza) {
		return trouverPizza(codePizza) != null;
	}
	
	@Override
	public Pizza trouverPizza(String codePizza) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		try {
			TypedQuery<Pizza> query = em.createQuery("SELECT p FROM Pizza p WHERE p.code=:codePizza", Pizza.class);
			query.setParameter("codePizza", codePizza);
			Pizza pizza = query.getSingleResult();
			em.close();
			return pizza;
		} catch (NoResultException e) {
			em.close();
			return null;
		}
	}
	
}
