package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
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
	public boolean executer() {
		
		System.out.print("Veuillez saisir le code : ");
		String codePizza = scanner.next();

		// tester si le code est pris
		boolean codePris = pizzaDao.codePizzaExiste(codePizza);
		
		// s'il n'est pas pris, saisir les informations suppl�mentaires et ajouter la pizza
		if (!codePris) {
			
			System.out.print("Veuillez saisir le nom : ");
			String nomPizzaAjoutee = scanner.next();
			
			System.out.print("Veuillez saisir le prix (utiliser , comme s�parateur d�cimal) : ");
			float prixPizzaAjoutee = scanner.nextFloat();
			
			Pizza pizzaAjoutee = new Pizza (codePizza, nomPizzaAjoutee, prixPizzaAjoutee);
			
			boolean succes = pizzaDao.ajouterPizza(pizzaAjoutee);
			if (succes) {
				System.out.println("La pizza de code " + codePizza + " a �t� ajout�e.");
			} else {
				System.out.println("Erreur : la pizza de code " + codePizza + " n'a pas pu �tre ajout�e.");
			}
			
			
		} else {
			System.out.println("Erreur : le code " + codePizza + " est d�j� pris.");
		}
		
		System.out.println();

		return true;
		
	}

}
