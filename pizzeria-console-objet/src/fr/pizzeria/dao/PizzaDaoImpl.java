package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.pizzeria.exception.AjouterPizzaException;
import fr.pizzeria.exception.ModifierPizzaException;
import fr.pizzeria.exception.SupprimerPizzaException;
import fr.pizzeria.model.Pizza;

public class PizzaDaoImpl implements IPizzaDao {
	
	
	// ==== Variables ====
	
	/**
	 * Pizzas affichées à la carte.
	 */
	private Map<String, Pizza> pizzas;
	
	// ==== Constructeurs ====
	
	/**
	 * Créer un DAO gérant une carte de pizzas pré-remplie.
	 */
	public PizzaDaoImpl() {

		// pizzas existantes
		
		pizzas = new HashMap<String, Pizza> ();
		
		Pizza[] pizzasParDefaut = new Pizza[] {
				new Pizza ("PEP", "Peperoni", 10),
				new Pizza ("MAR", "Margherita", 14),
				new Pizza ("REI", "La Reine", 11.5),
				new Pizza ("FRO", "La 4 fromages", 12),
				new Pizza ("CAN", "La cannibale", 12.5),
				new Pizza ("SAV", "La savoyarde", 13),
				new Pizza ("ORI", "L'orientale", 13.5),
				new Pizza ("IND", "L'indienne", 14),
			};
		
		for (Pizza p : pizzasParDefaut) {
			pizzas.put(p.getCode(), p);
		}
		
		
	}
	
	
	// ==== Méthodes ====

	/**
	 * Récupérer la liste des pizzas à la carte.
	 * @return Tableau de Pizza, qui est une copie des pizzas à la carte. 
	 */
	@Override
	public List<Pizza> listePizzas() {
		
		ArrayList<Pizza> copie = new ArrayList<Pizza>();
		copie.addAll(pizzas.values());
		return copie;
		
	}
	
	/**
	 * Insérer une nouvelle pizza dans la carte.
	 * @param pizzaAjoutee
	 * @return true si l'ajout réussi, false sinon.
	 * @throws AjouterPizzaException 
	 */
	@Override
	public void ajouterPizza(Pizza nouvellePizza) throws AjouterPizzaException {
		
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
	public void modifierPizza(String codePizza, Pizza pizzaApresModification) throws ModifierPizzaException {
		
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
	public void supprimerPizza(String codePizza) throws SupprimerPizzaException {
		
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
	public boolean codePizzaExiste(String codePizza) {
		return pizzas.containsKey(codePizza);
	}
	 
	
	/**
	 * Obtenir l'index de la pizza portant le code fourni.
	 * Important : Différent de la valeur Pizza.id
	 * @param codePizza
	 * @return L'index dans tableau où se trouve la pizza, ou -1 si le code n'a pas été trouvé.
	 */
	@Override
	@Deprecated
	public int obtenirIndexCodePizza(String codePizza) {
		return -1;
		
	}
	

	/**
	 * Obtenir la pizza portant le code fourni. 
	 * @param codePizza
	 * @return La pizza portant le code donné, ou null si le code est introuvable.
	 */
	@Override
	public Pizza trouverPizza(String codePizza) {
		return pizzas.get(codePizza);
		
	}
	

}
