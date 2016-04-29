package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.dao.AjouterPizzaException;
import fr.pizzeria.exception.dao.DaoException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * Option de menu pour ajouter une nouvelle pizza dans la carte.
 * @author oleflohic
 */
public class AjouterPizzaOptionMenu extends AbstractOptionMenu {

	// ==== Constantes ====
	
	private static final String AJOUTER_PIZZA_LIBELLE_MENU = "Ajouter une pizza";


	// ==== Constructeurs ====
	
	public AjouterPizzaOptionMenu(IPizzaDao pizzaDao, Scanner scanner) {
		super(AJOUTER_PIZZA_LIBELLE_MENU, pizzaDao, scanner);
	}

	
	// ==== M�thodes ====
	
	@Override
	public boolean executer() throws DaoException {
		
		System.out.print("Veuillez saisir le code : ");
		String codePizza = scanner.next();

		System.out.print("Veuillez saisir le nom : ");
		String nomPizzaAjoutee = scanner.next();
		
		System.out.print("Veuillez saisir le prix (utiliser , comme s�parateur d�cimal) : ");
		float prixPizzaAjoutee = scanner.nextFloat();

		System.out.println("Veuillez saisir la cat�gorie parmi les options suivantes (saisir le code) : ");
		CategoriePizza[] categoriesPizza = CategoriePizza.values();
		for (CategoriePizza c : categoriesPizza) {
			System.out.println(c);
		}
		System.out.print("Choix : ");
		String categoriePizzaAjoutee = scanner.next();
	
		try {
			CategoriePizza categorie = CategoriePizza.valueOf(categoriePizzaAjoutee);
			Pizza pizzaAjoutee = new Pizza (codePizza, nomPizzaAjoutee, prixPizzaAjoutee, categorie);
	
			pizzaDao.ajouterPizza(pizzaAjoutee);
			System.out.println("La pizza de code " + codePizza + " a �t� ajout�e.");
			
			System.out.println();
	
		} catch (IllegalArgumentException e) {
			throw new AjouterPizzaException ("Cat�gorie \"" + categoriePizzaAjoutee + "\" invalide.");
		}

		return true;
		
	}

}
