package fr.pizzeria.dao;

import fr.pizzeria.exception.AjouterPizzaException;
import fr.pizzeria.exception.ModifierPizzaException;
import fr.pizzeria.exception.SupprimerPizzaException;
import fr.pizzeria.model.Pizza;

/**
 * Interface de DAO pour interagir avec la carte des pizzas.
 * @author oleflohic
 */
public interface IPizzaDao {
	
	/**
	 * Récupérer la liste des pizzas à la carte.
	 * @return Tableau de Pizza, qui est une copie des pizzas à la carte. 
	 */
	public Pizza[] listePizzas ();
	
	/**
	 * Insérer une nouvelle pizza dans la carte.
	 * @param pizzaAjoutee
	 * @throws AjouterPizzaException
	 */
	public void ajouterPizza (Pizza pizzaAjoutee) throws AjouterPizzaException;

	/**
	 * Modifier la pizza portant le code donné pour qu'elle prenne les données fournies.
	 * @param codePizza Ancien code de la pizza à modifier.
	 * @param pizzaModifiee Nouvelle valeur de la pizza à modifier.
	 * @throws ModifierPizzaException
	 */
	public void modifierPizza (String codePizza, Pizza pizzaModifiee) throws ModifierPizzaException;

	/**
	 * Supprimer la pizza portant le code donné.
	 * @param codePizza
	 * @throws SupprimerPizzaException
	 */
	public void supprimerPizza (String codePizza) throws SupprimerPizzaException;
	
	
	// ajouts : actions utilitaires permettant de tester ou obtenir des valeurs en lecture seule
	/**
	 * Tester si le code pizza fourni existe déjà dans la carte.
	 * @param codePizza
	 * @return true si le code a été trouvé, false sinon.
	 */
	boolean codePizzaExiste (String codePizza);
	
	/**
	 * Obtenir l'index de la pizza portant le code fourni.
	 * Important : Différent de la valeur Pizza.id
	 * @param codePizza
	 * @return L'index dans tableau où se trouve la pizza, ou -1 si le code n'a pas été trouvé.
	 */
	int obtenirIndexCodePizza (String codePizza);
	
	/**
	 * Obtenir la pizza portant le code fourni. 
	 * @param codePizza
	 * @return La pizza portant le code donné, ou null si le code est introuvable.
	 */
	Pizza trouverPizza (String codePizza);
	
}
