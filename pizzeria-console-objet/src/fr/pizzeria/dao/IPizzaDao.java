package fr.pizzeria.dao;

import java.util.List;

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
	 * R�cup�rer la liste des pizzas � la carte.
	 * @return Tableau de Pizza, qui est une copie des pizzas � la carte. 
	 */
	public List<Pizza> listePizzas ();
	
	/**
	 * Ins�rer une nouvelle pizza dans la carte.
	 * @param pizzaAjoutee
	 * @throws AjouterPizzaException
	 */
	public void ajouterPizza (Pizza pizzaAjoutee) throws AjouterPizzaException;

	/**
	 * Modifier la pizza portant le code donn� pour qu'elle prenne les donn�es fournies.
	 * @param codePizza Ancien code de la pizza � modifier.
	 * @param pizzaModifiee Nouvelle valeur de la pizza � modifier.
	 * @throws ModifierPizzaException
	 */
	public void modifierPizza (String codePizza, Pizza pizzaModifiee) throws ModifierPizzaException;

	/**
	 * Supprimer la pizza portant le code donn�.
	 * @param codePizza
	 * @throws SupprimerPizzaException
	 */
	public void supprimerPizza (String codePizza) throws SupprimerPizzaException;
	
	
	// ajouts : actions utilitaires permettant de tester ou obtenir des valeurs en lecture seule
	/**
	 * Tester si le code pizza fourni existe d�j� dans la carte.
	 * @param codePizza
	 * @return true si le code a �t� trouv�, false sinon.
	 */
	public boolean codePizzaExiste (String codePizza);
	
	/**
	 * Obtenir la pizza portant le code fourni. 
	 * @param codePizza
	 * @return La pizza portant le code donn�, ou null si le code est introuvable.
	 */
	public Pizza trouverPizza (String codePizza);
	
}
