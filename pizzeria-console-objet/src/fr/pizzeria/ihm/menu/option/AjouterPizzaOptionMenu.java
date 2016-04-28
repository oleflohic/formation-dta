package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.Pizza;

public class AjouterPizzaOptionMenu extends AbstractOptionMenu {

	// CONSTANTES
	
	private static final String AJOUTER_PIZZA_LIBELLE_MENU = "Ajouter une pizza";


	// CONSTRUCTEURS
	
	public AjouterPizzaOptionMenu(IPizzaDao pizzaDao, Scanner scanner) {
		super(AJOUTER_PIZZA_LIBELLE_MENU, pizzaDao, scanner);
	}

	@Override
	public boolean executer() {
		
		System.out.print("Veuillez saisir le code : ");
		String codePizzaAjoutee = scanner.next();

		// tester si le code est pris
		boolean codePris = pizzaDao.codePizzaExiste(codePizzaAjoutee);
		
		// s'il n'est pas pris, saisir les informations supplémentaires et ajouter la pizza
		if (!codePris) {
			
			System.out.print("Veuillez saisir le nom : ");
			String nomPizzaAjoutee = scanner.next();
			
			System.out.print("Veuillez saisir le prix (utiliser , comme séparateur décimal) : ");
			float prixPizzaAjoutee = scanner.nextFloat();
			
			Pizza pizzaAjoutee = new Pizza (codePizzaAjoutee, nomPizzaAjoutee, prixPizzaAjoutee);
			
			boolean succes = pizzaDao.ajouterPizza(pizzaAjoutee);
			if (succes) {
				System.out.println("La pizza de code " + codePizzaAjoutee + " a été ajoutée.");
			} else {
				System.out.println("Erreur : la pizza de code " + codePizzaAjoutee + " n'a pas pu être ajoutée.");
			}
			
			
		} else {
			System.out.println("Erreur : le code " + codePizzaAjoutee + " est déjà pris.");
		}
		
		System.out.println();

		return true;
		
	}

}
