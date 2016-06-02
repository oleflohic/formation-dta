package fr.pizzeria.dao.pizza;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.pizzeria.exception.dao.AjouterPizzaException;
import fr.pizzeria.exception.dao.ModifierPizzaException;
import fr.pizzeria.exception.dao.SupprimerPizzaException;
import fr.pizzeria.model.Pizza;

@Repository
@Lazy
public class PizzaDaoJpaSpringImpl implements IPizzaDao {
	
	// ==== Variables ====
	
	/**
	 * 
	 */
	//@PersistenceContext(unitName="pizzeria-pu")
	
	private EntityManager em;
	
	
	// ==== Constructeurs ====
	@Autowired
	public PizzaDaoJpaSpringImpl (EntityManagerFactory entityManagerFactory) {
		em = entityManagerFactory.createEntityManager();
	}
	
	// ==== Méthodes ====
	
	@Override
	public List<Pizza> listePizzas() {
		return em.createQuery("SELECT p FROM Pizza p", Pizza.class).getResultList();
	}
	
	@Override
	@Transactional
	public void ajouterPizza(Pizza pizzaAjoutee) throws AjouterPizzaException {
		em.getTransaction().begin();
		try {
			em.persist(pizzaAjoutee);
			em.getTransaction().commit();
		} catch (PersistenceException e) {
			throw new AjouterPizzaException("Le code \"" + pizzaAjoutee.getCode() + "\" est déjà pris.");
		}
	}
	
	@Override
	public void modifierPizza(String codePizza, Pizza pizzaModifiee) throws ModifierPizzaException {
		em.getTransaction().begin();
		
		TypedQuery<Pizza> query = em.createQuery("SELECT p FROM Pizza p WHERE p.code=:codePizza", Pizza.class);
		query.setParameter("codePizza", codePizza);
		Pizza pizza = query.getSingleResult();
		
		pizza.setCode(pizzaModifiee.getCode());
		pizza.setNom(pizzaModifiee.getNom());
		pizza.setPrix(pizzaModifiee.getPrix());
		pizza.setCategorie(pizzaModifiee.getCategorie());

		em.getTransaction().commit();
	}
	
	@Override
	public void supprimerPizza(String codePizza) throws SupprimerPizzaException {
		em.getTransaction().begin();
		TypedQuery<Pizza> query = em.createQuery("SELECT p FROM Pizza p WHERE p.code=:codePizza", Pizza.class);
		query.setParameter("codePizza", codePizza);
		try {
			em.remove(query.getSingleResult());
			em.getTransaction().commit();
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
		em.getTransaction().begin();
		try {
			TypedQuery<Pizza> query = em.createQuery("SELECT p FROM Pizza p WHERE p.code=:codePizza", Pizza.class);
			query.setParameter("codePizza", codePizza);
			Pizza pizza = query.getSingleResult();
			return pizza;
		} catch (NoResultException e) {
			return null;
		}
	}
	
	@Override
	public void ajouterGroupePizzas(List<Pizza> pizzasAInserer) {
		throw new UnsupportedOperationException();
	}
	
}
