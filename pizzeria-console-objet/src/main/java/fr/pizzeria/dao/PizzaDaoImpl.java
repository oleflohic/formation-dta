package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.pizzeria.exception.dao.AjouterPizzaException;
import fr.pizzeria.exception.dao.ModifierPizzaException;
import fr.pizzeria.exception.dao.SupprimerPizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoImpl implements IPizzaDao {
	
	
	// ==== Variables ====
	
	/**
	 * Pizzas affichées à la carte.
	 */
	private Map<String, Pizza> pizzas;
	
	
	// ==== Méthodes statiques ====
	
	public static Pizza[] pizzasParDefaut () {
		return new Pizza[] {
				new Pizza ("PEP", "Peperoni", 10, CategoriePizza.VIANDE),
				new Pizza ("MAR", "Margherita", 14, CategoriePizza.SANS_VIANDE),
				new Pizza ("REI", "La Reine", 11.5, CategoriePizza.VIANDE),
				new Pizza ("FRO", "La 4 fromages", 12, CategoriePizza.SANS_VIANDE),
				new Pizza ("CAN", "La cannibale", 12.5, CategoriePizza.VIANDE),
				new Pizza ("SAV", "La savoyarde", 13, CategoriePizza.VIANDE),
				new Pizza ("ORI", "L'orientale", 13.5, CategoriePizza.VIANDE),
				new Pizza ("IND", "L'indienne", 14, CategoriePizza.VIANDE),
				new Pizza ("SAU", "La saumoneta", 14, CategoriePizza.POISSON),
			};
	}
	
	
	// ==== Constructeurs ====
	
	/**
	 * Créer un DAO gérant une carte de pizzas pré-remplie.
	 */
	public PizzaDaoImpl() {

		// pizzas existantes
		
		pizzas = new HashMap<String, Pizza> ();
		
		for (Pizza p : pizzasParDefaut()) {
			pizzas.put(p.getCode(), p);
		}
		
		
	}
	
	
	// ==== Méthodes ====

	/**
	 * Récupérer la liste des pizzas à la carte.
	 * @return Tableau de Pizza, qui est une copie des pizzas à la carte. 
	 */
	@Override
	public List<Pizza> listePizzas() { // equivalent correction : findAllPizzas
		return new ArrayList<Pizza>(pizzas.values());
	}
	
	/**
	 * Insérer une nouvelle pizza dans la carte.
	 * @param pizzaAjoutee
	 * @return true si l'ajout réussi, false sinon.
	 * @throws AjouterPizzaException 
	 */
	@Override
	public void ajouterPizza(Pizza nouvellePizza) throws AjouterPizzaException { // equivalent correction : savePizza
		
		// code de longueur invalide : exception
		if (nouvellePizza.getCode().length() != 3) {
			throw new AjouterPizzaException ("Le code pizza " + nouvellePizza.getCode() + " est de longueur invalide (doit contenir 3 caractères).");
		}
		
		// le code n'est pas encore pris : ajouter la pizza
		if (! pizzas.containsKey(nouvellePizza.getCode())) {
			pizzas.put(nouvellePizza.getCode(), nouvellePizza);
		} else {
			throw new AjouterPizzaException ("Le code pizza " + nouvellePizza.getCode() + " est déjà pris.");
		}
		
	}
	
	/**
	 * Modifier la pizza portant le code donné pour qu'elle prenne les données fournies.
	 * @param codePizza Ancien code de la pizza à modifier.
	 * @param pizzaModifiee Nouvelle valeur de la pizza à modifier.
	 * @return true si la modification a réussi, false sinon.
	 * @throws ModifierPizzaException 
	 */
	@Override
	public void modifierPizza(String codePizza, Pizza pizzaApresModification) throws ModifierPizzaException { // equivalent correction : updatePizza
		
		// code différent de l'original : tester si le nouveau n'est pas déjà pris
		if (! codePizza.equals(pizzaApresModification.getCode())) {
			
			if (pizzas.containsKey(pizzaApresModification.getCode())) {
				throw new ModifierPizzaException ("Le code pizza " + pizzaApresModification.getCode() + " est déjà pris.");
			}
			
		}
		
		// nouveau code de longueur invalide
		if (pizzaApresModification.getCode().length() != 3) {
			throw new ModifierPizzaException ("Le nouveau code pizza " + pizzaApresModification.getCode() + " est de longueur invalide (doit contenir 3 caractères).");			
		}
		
		if (pizzas.containsKey(codePizza)) {
			// changement de clé : supprimer l'ancienne instance
			if (! codePizza.equals(pizzaApresModification.getCode())) {
				pizzas.remove(codePizza);
			}
			
			// dans tous les cas, ajouter la nouvelle (écrase l'ancienne si même clé)
			pizzas.put(pizzaApresModification.getCode(), pizzaApresModification);
		} else {
			throw new ModifierPizzaException ("Le code pizza " + codePizza + " est introuvable.");
		}
		
	}

	/**
	 * Supprimer la pizza portant le code donné.
	 * @param codePizza
	 * @return true si la suppression a réussi, false sinon.
	 * @throws SupprimerPizzaException 
	 */
	@Override
	public void supprimerPizza(String codePizza) throws SupprimerPizzaException { // equivalent correction : deletePizza
		
		// tenter de supprimer la pizza ; en cas d'échec, lancer l'exception
		if (pizzas.remove(codePizza) == null) {
			throw new SupprimerPizzaException ("Le code pizza " + codePizza + " est introuvable.");
		}
		
	}
	
	/**
	 * Tester si le code pizza fourni existe déjà dans la carte.
	 * @param codePizza
	 * @return true si le code a été trouvé, false sinon.
	 */
	@Override
	public boolean codePizzaExiste(String codePizza) { // pas dans la correction
		return pizzas.containsKey(codePizza);
	}
	
	/**
	 * Obtenir la pizza portant le code fourni. 
	 * @param codePizza
	 * @return La pizza portant le code donné, ou null si le code est introuvable.
	 */
	@Override
	public Pizza trouverPizza(String codePizza) { // pas dans la correction
		return pizzas.get(codePizza);
	}
	
	
	

}
