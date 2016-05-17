package fr.pizzeria.ihm.menu.option;

import java.math.BigDecimal;
import java.util.Scanner;

import fr.pizzeria.dao.admin.IPizzaDao;
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

	
	// ==== Méthodes ====
	
	@Override
	public boolean executer() throws DaoException {
		
		System.out.println("Veuillez saisir le code : ");
		String codePizza = scanner.next();

		System.out.println("Veuillez saisir le nom : ");
		String nomPizzaAjoutee = scanner.next();
		
		System.out.println("Veuillez saisir le prix (utiliser , comme séparateur décimal) : ");
		String prixPizzaAjoutee = scanner.next();

		System.out.println("Veuillez saisir la catégorie parmi les options suivantes (saisir le code) : ");
		CategoriePizza[] categoriesPizza = CategoriePizza.values();
		for (CategoriePizza c : categoriesPizza) {
			System.out.println(c);
		}
		System.out.println("Choix : ");
		String categoriePizzaAjoutee = scanner.next();
	
		try {
			CategoriePizza categorie = CategoriePizza.valueOf(categoriePizzaAjoutee);
			Pizza pizzaAjoutee = new Pizza (codePizza, nomPizzaAjoutee, new BigDecimal(prixPizzaAjoutee), categorie);
	
			pizzaDao.ajouterPizza(pizzaAjoutee);
			System.out.println("La pizza de code " + codePizza + " a été ajoutée.");
			
			System.out.println();
	
		} catch (IllegalArgumentException e) {
			throw new AjouterPizzaException ("Catégorie \"" + categoriePizzaAjoutee + "\" invalide.");
		}

		return true;
		
	}

}
