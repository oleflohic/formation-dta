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
	 * Pizzas affich�es � la carte.
	 */
	private Map<String, Pizza> pizzas;
	
	// ==== Constructeurs ====
	
	/**
	 * Cr�er un DAO g�rant une carte de pizzas pr�-remplie.
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
	
	
	// ==== M�thodes ====

	/**
	 * R�cup�rer la liste des pizzas � la carte.
	 * @return Tableau de Pizza, qui est une copie des pizzas � la carte. 
	 */
	@Override
	public List<Pizza> listePizzas() {
		
		ArrayList<Pizza> copie = new ArrayList<Pizza>();
		copie.addAll(pizzas.values());
		return copie;
		
	}
	
	/**
	 * Ins�rer une nouvelle pizza dans la carte.
	 * @param pizzaAjoutee
	 * @return true si l'ajout r�ussi, false sinon.
	 * @throws AjouterPizzaException 
	 */
	@Override
	public void ajouterPizza(Pizza nouvellePizza) throws AjouterPizzaException {
		
		// le code n'est pas encore pris : ajouter la pizza
		if (! pizzas.containsKey(nouvellePizza.getCode())) {
			pizzas.put(nouvellePizza.getCode(), nouvellePizza);
		} else {
			throw new AjouterPizzaException ("Le code pizza " + nouvellePizza.getCode() + " est d�j� pris.");
		}
		
	}
	
	/**
	 * Modifier la pizza portant le code donn� pour qu'elle prenne les donn�es fournies.
	 * @param codePizza Ancien code de la pizza � modifier.
	 * @param pizzaModifiee Nouvelle valeur de la pizza � modifier.
	 * @return true si la modification a r�ussi, false sinon.
	 * @throws ModifierPizzaException 
	 */
	@Override
	public void modifierPizza(String codePizza, Pizza pizzaApresModification) throws ModifierPizzaException {
		
		if (pizzas.containsKey(codePizza)) {
			// changement de cl� : supprimer l'ancienne instance
			if (! codePizza.equals(pizzaApresModification.getCode())) {
				pizzas.remove(codePizza);
			}
			
			// dans tous les cas, ajouter la nouvelle (�crase l'ancienne si m�me cl�)
			pizzas.put(pizzaApresModification.getCode(), pizzaApresModification);
		} else {
			throw new ModifierPizzaException ("Le code pizza " + codePizza + " est introuvable.");
		}
		
		
	}

	/**
	 * Supprimer la pizza portant le code donn�.
	 * @param codePizza
	 * @return true si la suppression a r�ussi, false sinon.
	 * @throws SupprimerPizzaException 
	 */
	@Override
	public void supprimerPizza(String codePizza) throws SupprimerPizzaException {
		
		// tenter de supprimer la pizza ; en cas d'�chec, lancer l'exception
		if (pizzas.remove(codePizza) == null) {
			throw new SupprimerPizzaException ("Le code pizza " + codePizza + " est introuvable.");
		}
		
	}
	
	/**
	 * Tester si le code pizza fourni existe d�j� dans la carte.
	 * @param codePizza
	 * @return true si le code a �t� trouv�, false sinon.
	 */
	@Override
	public boolean codePizzaExiste(String codePizza) {
		return pizzas.containsKey(codePizza);
	}
	 
	
	/**
	 * Obtenir l'index de la pizza portant le code fourni.
	 * Important : Diff�rent de la valeur Pizza.id
	 * @param codePizza
	 * @return L'index dans tableau o� se trouve la pizza, ou -1 si le code n'a pas �t� trouv�.
	 */
	@Override
	@Deprecated
	public int obtenirIndexCodePizza(String codePizza) {
		return -1;
		
	}
	

	/**
	 * Obtenir la pizza portant le code fourni. 
	 * @param codePizza
	 * @return La pizza portant le code donn�, ou null si le code est introuvable.
	 */
	@Override
	public Pizza trouverPizza(String codePizza) {
		return pizzas.get(codePizza);
		
	}
	

}
