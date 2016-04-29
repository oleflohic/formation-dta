package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.DaoException;
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
		
		System.out.print("Veuillez saisir le code : ");
		String codePizza = scanner.next();


		System.out.print("Veuillez saisir le nom : ");
		String nomPizzaAjoutee = scanner.next();
		
		System.out.print("Veuillez saisir le prix (utiliser , comme séparateur décimal) : ");
		float prixPizzaAjoutee = scanner.nextFloat();
		
		Pizza pizzaAjoutee = new Pizza (codePizza, nomPizzaAjoutee, prixPizzaAjoutee);

		pizzaDao.ajouterPizza(pizzaAjoutee);
		System.out.println("La pizza de code " + codePizza + " a été ajoutée.");
		
		/*
		
		// si le code n'est pas déjà pris, saisir les informations supplémentaires et ajouter la pizza
		if (! pizzaDao.codePizzaExiste(codePizza)) {
			
			System.out.print("Veuillez saisir le nom : ");
			String nomPizzaAjoutee = scanner.next();
			
			System.out.print("Veuillez saisir le prix (utiliser , comme séparateur décimal) : ");
			float prixPizzaAjoutee = scanner.nextFloat();
			
			Pizza pizzaAjoutee = new Pizza (codePizza, nomPizzaAjoutee, prixPizzaAjoutee);

			pizzaDao.ajouterPizza(pizzaAjoutee);
			System.out.println("La pizza de code " + codePizza + " a été ajoutée.");
			
		} else {
			System.out.println("Erreur : le code " + codePizza + " est déjà pris.");
		}
		*/
		
		System.out.println();

		return true;
		
	}

}
