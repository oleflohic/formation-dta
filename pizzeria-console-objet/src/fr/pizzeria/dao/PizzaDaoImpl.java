package fr.pizzeria.dao;

import fr.pizzeria.exception.AjouterPizzaException;
import fr.pizzeria.exception.ModifierPizzaException;
import fr.pizzeria.exception.SupprimerPizzaException;
import fr.pizzeria.model.Pizza;

public class PizzaDaoImpl implements IPizzaDao {
	
	
	// ==== Variables ====
	
	/**
	 * Pizzas affichées à la carte.
	 */
	private Pizza[] pizzas;
	
	
	// ==== Constructeurs ====
	
	/**
	 * Créer un DAO gérant une carte de pizzas pré-remplie.
	 */
	public PizzaDaoImpl() {

		// pizzas existantes
		pizzas = new Pizza[] {
				new Pizza ("PEP", "Peperoni", 10),
				new Pizza ("MAR", "Margherita", 14),
				new Pizza ("REI", "La Reine", 11.5),
				new Pizza ("FRO", "La 4 fromages", 12),
				new Pizza ("CAN", "La cannibale", 12.5),
				new Pizza ("SAV", "La savoyarde", 13),
				new Pizza ("ORI", "L'orientale", 13.5),
				new Pizza ("IND", "L'indienne", 14),
			};
		
	}
	
	
	// ==== Méthodes ====

	/**
	 * Récupérer la liste des pizzas à la carte.
	 * @return Tableau de Pizza, qui est une copie des pizzas à la carte. 
	 */
	@Override
	public Pizza[] listePizzas() {
		Pizza[] copie = new Pizza[pizzas.length];
		System.arraycopy(pizzas, 0, copie, 0, pizzas.length);
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
		if (! codePizzaExiste (nouvellePizza.getCode())) {

			// copier le contenu de la vieille liste dans la nouvelle,
			// puis mettre la nouvelle pizza à sa fin
			Pizza[] pizzasApresAjout = new Pizza[pizzas.length+1];
			for (int i = 0 ; i < pizzas.length ; i++) {
				pizzasApresAjout[i] = pizzas[i];
			}
			pizzasApresAjout[pizzas.length] = nouvellePizza;
			pizzas = pizzasApresAjout;
			
		} else {
			throw new AjouterPizzaException ("Le code pizza " + nouvellePizza.getCode() + " est introuvable.");
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
		
		// trouver l'index de la pizza à modifier dans le tableau et la remplacer si l'index est valide 
		int indexTableau = obtenirIndexCodePizza(codePizza);
		if (indexTableau != -1) {
			pizzas[indexTableau] = pizzaApresModification;
			//return true;
		} else {
			//return false;
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
		
		Pizza[] pizzasApresSuppression = new Pizza[pizzas.length-1];
		int indexPizzaASupprimer = obtenirIndexCodePizza(codePizza);
		
		if (indexPizzaASupprimer != -1) {
			
			// créer un nouveau tableau qui ne contient pas l'élément supprimé
			if (indexPizzaASupprimer == 0) { // cas début de liste
				
				for (int i = 1 ; i < pizzas.length ; i++) {
					pizzasApresSuppression[i-1] = pizzas[i];
				}
				
			} else if (indexPizzaASupprimer == (pizzas.length - 1)) { // cas fin de liste
	
				for (int i = 0 ; i < pizzas.length-1 ; i++) {
					pizzasApresSuppression[i] = pizzas[i];
				}
				
			} else { // cas milieu de liste
				
				// avant l'index de la pizza supprimée
				for (int i = 0 ; i < indexPizzaASupprimer ; i++) {
					pizzasApresSuppression[i] = pizzas[i];
				}
				
				// après l'index
				for (int i = indexPizzaASupprimer+1 ; i < pizzas.length ; i++) {
					pizzasApresSuppression[i-1] = pizzas[i];
				}
				
			}
			
			// remplacement de la liste
			pizzas = pizzasApresSuppression;
			
		} else {
			throw new SupprimerPizzaException ("Le code pizza " + codePizza + " est introuvable.");
		}
		
		
		//return true;
	}

	/**
	 * Tester si le code pizza fourni existe déjà dans la carte.
	 * @param codePizza
	 * @return true si le code a été trouvé, false sinon.
	 */
	@Override
	public boolean codePizzaExiste(String codePizza) {
		return (obtenirIndexCodePizza(codePizza) != -1);
	}


	/**
	 * Obtenir l'index de la pizza portant le code fourni.
	 * Important : Différent de la valeur Pizza.id
	 * @param codePizza
	 * @return L'index dans tableau où se trouve la pizza, ou -1 si le code n'a pas été trouvé.
	 */
	@Override
	public int obtenirIndexCodePizza(String codePizza) {
		for (int i = 0 ; i < pizzas.length ; i++) {
			if (pizzas[i].getCode().equals(codePizza)) {
				return i;
			}
		}
		return -1;
	}
	

	/**
	 * Obtenir la pizza portant le code fourni. 
	 * @param codePizza
	 * @return La pizza portant le code donné, ou null si le code est introuvable.
	 */
	@Override
	public Pizza trouverPizza(String codePizza) {
		int index = obtenirIndexCodePizza(codePizza);
		if (index == -1) {
			return null;	
		} else {
			return pizzas[index].clone();
		}
	}
	

}
