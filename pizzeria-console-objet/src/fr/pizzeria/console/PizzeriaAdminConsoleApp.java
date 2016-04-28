package fr.pizzeria.console;

import java.util.Scanner;

//import fr.pizzeria.ihm.MenuPizzeria;
import fr.pizzeria.ihm.menu.Menu;

/**
 * classe de point d'entrée de l'application
 * @author oleflohic
 */
public class PizzeriaAdminConsoleApp {
	
	/**
	 * Méthode principale.
	 * @param args Arguments du programme.
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Menu menu = new Menu (sc);
		menu.afficher();
		
		sc.close();
		

	}

}
