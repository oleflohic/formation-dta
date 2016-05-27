package fr.pizzeria.admin.metier;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

@Stateless
public class PizzaService {
	
	// ==== Variables ====
	@PersistenceContext(unitName="pizzeria-admin-app") private EntityManager em;
	
	
	// ==== Méthodes ====

	
    @PostConstruct 
    public void peuplerBdd() {
    	String imgSrc = "http://placehold.it/75x75";
	
    	// TODO modifier la classe pour que la persistance ne provoque pas une recréation systématique
    	
    	// REMARQUE : récrée les pizzas à chaque page. En cas de suppression, cette dernière est annulée dès le rechargement de la page.
    	// AUTRE PROBLEME : utilise la valeur id comme index, qui est générée automatiquement. Supprimer l'original provoquera une recréation systématique
    	// des pizzas, ce qui se heurtera à des problèmes de doublons de code, ce qui n'est pas autorisé par les contraintes d'intégrité.
    	
		if (em.find(Pizza.class, 1) == null)	em.persist(new Pizza ("PEP", "Peperoni",		new BigDecimal("10"),	CategoriePizza.VIANDE,		imgSrc));
		if (em.find(Pizza.class, 2) == null)	em.persist(new Pizza ("MAR", "Margherita",		new BigDecimal("14"),	CategoriePizza.SANS_VIANDE,	imgSrc));
		if (em.find(Pizza.class, 3) == null)	em.persist(new Pizza ("REI", "La Reine",		new BigDecimal("11.5"),	CategoriePizza.VIANDE,		imgSrc));
		if (em.find(Pizza.class, 4) == null)	em.persist(new Pizza ("FRO", "La 4 fromages",	new BigDecimal("12"),	CategoriePizza.SANS_VIANDE,	imgSrc));
		if (em.find(Pizza.class, 5) == null)	em.persist(new Pizza ("CAN", "La cannibale",	new BigDecimal("12.5"),	CategoriePizza.VIANDE,		imgSrc));
		if (em.find(Pizza.class, 6) == null)	em.persist(new Pizza ("SAV", "La savoyarde",	new BigDecimal("13"),	CategoriePizza.VIANDE,		imgSrc));
		if (em.find(Pizza.class, 7) == null)	em.persist(new Pizza ("ORI", "L'orientale",		new BigDecimal("13.5"),	CategoriePizza.VIANDE,		imgSrc));
		if (em.find(Pizza.class, 8) == null)	em.persist(new Pizza ("IND", "L'indienne",		new BigDecimal("14"),	CategoriePizza.VIANDE,		imgSrc));
		if (em.find(Pizza.class, 9) == null)	em.persist(new Pizza ("SAU", "La saumoneta",	new BigDecimal("14"),	CategoriePizza.POISSON,		imgSrc));
    }
	
	@SuppressWarnings("unchecked")
	public List<Pizza> listePizzas() {
		return (List<Pizza>)em.createQuery("SELECT p FROM Pizza p").getResultList();
	}
	
	public Pizza trouverPizza(String codePizza) {
		Query requete = em.createQuery("SELECT p FROM Pizza p WHERE p.code=:code", Pizza.class);
		requete.setParameter("code", codePizza);
		return (Pizza)requete.getSingleResult();
	}
	
	public void modifierPizza (String ancienCode, Pizza pizza) {
		
		Query requete = em.createQuery("SELECT p FROM Pizza p WHERE p.code=:code", Pizza.class);
		
		requete.setParameter("code", ancienCode);
		
		Pizza anciennePizza = (Pizza)requete.getSingleResult();
		
		if (anciennePizza == null) {
			// ERREUR : ne peut pas modifier une pizza inexistante
			
			System.err.println("CODE " + ancienCode + " INVALIDE");
			
		} else {
			
			//em.getTransaction().begin();
			
			anciennePizza.setNom(pizza.getNom());
			anciennePizza.setCategorie(pizza.getCategorie());
			anciennePizza.setPrix(pizza.getPrix());
			anciennePizza.setUrlImage(pizza.getUrlImage());
			
			//em.getTransaction().commit();
			
		}
		
	}
	
	public void ajouterPizza (Pizza pizza) {
		try {
			
			//em.createQuery("INSERT INTO Pizza p SELECT p.nom, p.code, p.categorie, p.prix, p.url_image ")
			
			em.persist(pizza);
		} catch (EntityExistsException e) {
			System.err.println("CODE " + pizza.getCode() + " DEJA PRIS");
		}
	}
	
	
	// @Schedule(second="*/10", minute="*", hour="*")
	/*
	public void rdmPizza () {
		try {
			System.out.println("AJOUT PIZZA");
			pizzaDao.ajouterPizza(new Pizza("" + (int)(Math.random()*1000), "randompizza", BigDecimal.ZERO, CategoriePizza.SANS_VIANDE, ""));
			System.out.println("> " + pizzaDao.listePizzas().size());
			
		} catch (AjouterPizzaException e) {
			e.printStackTrace();
			System.out.println("echec ajout");
		}
	}
	*/
	
	
	
	
	
}
