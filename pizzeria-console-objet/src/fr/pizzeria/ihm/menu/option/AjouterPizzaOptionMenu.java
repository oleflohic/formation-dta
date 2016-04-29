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

	
	// ==== M�thodes ====
	
	@Override
	public boolean executer() throws DaoException {
		
		System.out.print("Veuillez saisir le code : ");
		String codePizza = scanner.next();


		System.out.print("Veuillez saisir le nom : ");
		String nomPizzaAjoutee = scanner.next();
		
		System.out.print("Veuillez saisir le prix (utiliser , comme s�parateur d�cimal) : ");
		float prixPizzaAjoutee = scanner.nextFloat();
		
		Pizza pizzaAjoutee = new Pizza (codePizza, nomPizzaAjoutee, prixPizzaAjoutee);

		pizzaDao.ajouterPizza(pizzaAjoutee);
		System.out.println("La pizza de code " + codePizza + " a �t� ajout�e.");
		
		/*
		
		// si le code n'est pas d�j� pris, saisir les informations suppl�mentaires et ajouter la pizza
		if (! pizzaDao.codePizzaExiste(codePizza)) {
			
			System.out.print("Veuillez saisir le nom : ");
			String nomPizzaAjoutee = scanner.next();
			
			System.out.print("Veuillez saisir le prix (utiliser , comme s�parateur d�cimal) : ");
			float prixPizzaAjoutee = scanner.nextFloat();
			
			Pizza pizzaAjoutee = new Pizza (codePizza, nomPizzaAjoutee, prixPizzaAjoutee);

			pizzaDao.ajouterPizza(pizzaAjoutee);
			System.out.println("La pizza de code " + codePizza + " a �t� ajout�e.");
			
		} else {
			System.out.println("Erreur : le code " + codePizza + " est d�j� pris.");
		}
		*/
		
		System.out.println();

		return true;
		
	}

}
