package fr.pizzeria.dao;

import fr.pizzeria.exception.AjouterPizzaException;
import fr.pizzeria.exception.ModifierPizzaException;
import fr.pizzeria.exception.SupprimerPizzaException;
import fr.pizzeria.model.Pizza;

public class PizzaDaoImpl implements IPizzaDao {
	
	
	// ==== Variables ====
	
	/**
	 * Pizzas affich�es � la carte.
	 */
	private Pizza[] pizzas;
	
	
	// ==== Constructeurs ====
	
	/**
	 * Cr�er un DAO g�rant une carte de pizzas pr�-remplie.
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
	
	
	// ==== M�thodes ====

	/**
	 * R�cup�rer la liste des pizzas � la carte.
	 * @return Tableau de Pizza, qui est une copie des pizzas � la carte. 
	 */
	@Override
	public Pizza[] listePizzas() {
		Pizza[] copie = new Pizza[pizzas.length];
		System.arraycopy(pizzas, 0, copie, 0, pizzas.length);
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
		if (! codePizzaExiste (nouvellePizza.getCode())) {

			// copier le contenu de la vieille liste dans la nouvelle,
			// puis mettre la nouvelle pizza � sa fin
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
	 * Modifier la pizza portant le code donn� pour qu'elle prenne les donn�es fournies.
	 * @param codePizza Ancien code de la pizza � modifier.
	 * @param pizzaModifiee Nouvelle valeur de la pizza � modifier.
	 * @return true si la modification a r�ussi, false sinon.
	 * @throws ModifierPizzaException 
	 */
	@Override
	public void modifierPizza(String codePizza, Pizza pizzaApresModification) throws ModifierPizzaException {
		
		// trouver l'index de la pizza � modifier dans le tableau et la remplacer si l'index est valide 
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
	 * Supprimer la pizza portant le code donn�.
	 * @param codePizza
	 * @return true si la suppression a r�ussi, false sinon.
	 * @throws SupprimerPizzaException 
	 */
	@Override
	public void supprimerPizza(String codePizza) throws SupprimerPizzaException {
		
		Pizza[] pizzasApresSuppression = new Pizza[pizzas.length-1];
		int indexPizzaASupprimer = obtenirIndexCodePizza(codePizza);
		
		if (indexPizzaASupprimer != -1) {
			
			// cr�er un nouveau tableau qui ne contient pas l'�l�ment supprim�
			if (indexPizzaASupprimer == 0) { // cas d�but de liste
				
				for (int i = 1 ; i < pizzas.length ; i++) {
					pizzasApresSuppression[i-1] = pizzas[i];
				}
				
			} else if (indexPizzaASupprimer == (pizzas.length - 1)) { // cas fin de liste
	
				for (int i = 0 ; i < pizzas.length-1 ; i++) {
					pizzasApresSuppression[i] = pizzas[i];
				}
				
			} else { // cas milieu de liste
				
				// avant l'index de la pizza supprim�e
				for (int i = 0 ; i < indexPizzaASupprimer ; i++) {
					pizzasApresSuppression[i] = pizzas[i];
				}
				
				// apr�s l'index
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
	 * Tester si le code pizza fourni existe d�j� dans la carte.
	 * @param codePizza
	 * @return true si le code a �t� trouv�, false sinon.
	 */
	@Override
	public boolean codePizzaExiste(String codePizza) {
		return (obtenirIndexCodePizza(codePizza) != -1);
	}


	/**
	 * Obtenir l'index de la pizza portant le code fourni.
	 * Important : Diff�rent de la valeur Pizza.id
	 * @param codePizza
	 * @return L'index dans tableau o� se trouve la pizza, ou -1 si le code n'a pas �t� trouv�.
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
	 * @return La pizza portant le code donn�, ou null si le code est introuvable.
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
