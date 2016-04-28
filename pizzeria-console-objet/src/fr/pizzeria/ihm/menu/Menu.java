package fr.pizzeria.ihm.menu;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.ihm.menu.option.AbstractOptionMenu;
import fr.pizzeria.ihm.menu.option.AjouterPizzaOptionMenu;
import fr.pizzeria.ihm.menu.option.ListerPizzasOptionMenu;
import fr.pizzeria.ihm.menu.option.ModifierPizzaOptionMenu;
import fr.pizzeria.ihm.menu.option.QuitterOptionMenu;
import fr.pizzeria.ihm.menu.option.SupprimerPizzaOptionMenu;

/**
 * Menu principal de l'application. Permet d'�couter les saisies clavier et d'ex�cuter les actions en cons�quence.
 * @author oleflohic
 */
public class Menu {
	
	// ==== Constantes =====
	
	public static final String MENU_TITRE_LIBELLE = "Application Pizzeria Console";
	
	
	// ==== Variables =====
	
	/**
	 * Liste des options disponibles � l'utilisateur.
	 */
	private AbstractOptionMenu[] options;
	
	/**
	 * Lecteur de saisies clavier.
	 */
	private Scanner scanner;
	
	
	// ==== Constructeurs ====
	
	/**
	 * Cr�er un menu console.
	 * @param scanner
	 */
	public Menu (Scanner scanner) {
		IPizzaDao pizzaDao = new PizzaDaoImpl();
		initialiserOptions (scanner, pizzaDao);
		this.scanner = scanner;
	}
	
	
	// ==== M�thodes ====
	
	/**
	 * Initialiser le menu en d�ifnissant des options.
	 * @param scanner
	 * @param pizzaDao
	 */
	public void initialiserOptions (Scanner scanner, IPizzaDao pizzaDao) {
		options = new AbstractOptionMenu[] {
				new ListerPizzasOptionMenu(pizzaDao),
				new AjouterPizzaOptionMenu(pizzaDao, scanner),
				new ModifierPizzaOptionMenu(pizzaDao, scanner),
				new SupprimerPizzaOptionMenu(pizzaDao, scanner),
				new QuitterOptionMenu()
		};
	}
	
	/**
	 * Afficher les options disponibles.
	 */
	public void afficher () {
		boolean continuer = true;
		
		while (continuer) {
			System.out.println("**** " + MENU_TITRE_LIBELLE + " ****");
			
			for (int i = 0 ; i < options.length ; i++) {
				System.out.println("" + i + ". " + options[i].getLibelle());
			}
			
			int saisie = scanner.nextInt();
			continuer = options[saisie].executer();			
		}
		
	}
	
}
