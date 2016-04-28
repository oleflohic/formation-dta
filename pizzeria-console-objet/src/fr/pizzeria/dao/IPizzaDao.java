package fr.pizzeria.dao;

import fr.pizzeria.model.Pizza;

/**
 * Interface de DAO pour interagir avec la carte des pizzas.
 * @author oleflohic
 */
public interface IPizzaDao {
	
	/**
	 * R�cup�rer la liste des pizzas � la carte.
	 * @return Tableau de Pizza, qui est une copie des pizzas � la carte. 
	 */
	public Pizza[] listePizzas ();
	
	/**
	 * Ins�rer une nouvelle pizza dans la carte.
	 * @param pizzaAjoutee
	 * @return true si l'ajout r�ussi, false sinon.
	 */
	boolean ajouterPizza (Pizza pizzaAjoutee);

	/**
	 * Modifier la pizza portant le code donn� pour qu'elle prenne les donn�es fournies.
	 * @param codePizza Ancien code de la pizza � modifier.
	 * @param pizzaModifiee Nouvelle valeur de la pizza � modifier.
	 * @return true si la modification a r�ussi, false sinon.
	 */
	boolean modifierPizza (String codePizza, Pizza pizzaModifiee);
	
	/**
	 * Supprimer la pizza portant le code donn�.
	 * @param codePizza
	 * @return true si la suppression a r�ussi, false sinon.
	 */
	boolean supprimerPizza (String codePizza);
	
	
	// ajouts : actions utilitaires permettant de tester ou obtenir des valeurs en lecture seule
	/**
	 * Tester si le code pizza fourni existe d�j� dans la carte.
	 * @param codePizza
	 * @return true si le code a �t� trouv�, false sinon.
	 */
	boolean codePizzaExiste (String codePizza);
	
	/**
	 * Obtenir l'index de la pizza portant le code fourni.
	 * Important : Diff�rent de la valeur Pizza.id
	 * @param codePizza
	 * @return L'index dans tableau o� se trouve la pizza, ou -1 si le code n'a pas �t� trouv�.
	 */
	int obtenirIndexCodePizza (String codePizza);
	
	/**
	 * Obtenir la pizza portant le code fourni. 
	 * @param codePizza
	 * @return La pizza portant le code donn�, ou null si le code est introuvable.
	 */
	Pizza trouverPizza (String codePizza);
	
}
