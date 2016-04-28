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

public class Menu {
	
	public static final String MENU_TITRE_LIBELLE = "Application Pizzeria Console";
	private AbstractOptionMenu[] options;
	private Scanner sc;
	
	public Menu (Scanner sc) {
		IPizzaDao dao = new PizzaDaoImpl();
		initialiserOptions (sc, dao);
		this.sc = sc;
	}
	
	public void initialiserOptions (Scanner sc, IPizzaDao pizzaDao) {
		options = new AbstractOptionMenu[] {
				new ListerPizzasOptionMenu(pizzaDao),
				new AjouterPizzaOptionMenu(pizzaDao, sc),
				new ModifierPizzaOptionMenu(pizzaDao, sc),
				new SupprimerPizzaOptionMenu(pizzaDao, sc),
				new QuitterOptionMenu()
		};
	}
	
	public void afficher () {
		boolean continuer = true;
		
		while (continuer) {
			System.out.println("**** " + MENU_TITRE_LIBELLE + " ****");
			
			for (int i = 0 ; i < options.length ; i++) {
				System.out.println("" + i + ". " + options[i].getLibelle());
			}
			
			int saisie = sc.nextInt();
			continuer = options[saisie].executer();			
		}
		
	}
	
}
