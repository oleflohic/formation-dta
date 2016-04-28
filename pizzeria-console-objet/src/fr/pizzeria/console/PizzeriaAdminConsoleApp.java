package fr.pizzeria.console;

import java.util.Scanner;

//import fr.pizzeria.ihm.MenuPizzeria;
import fr.pizzeria.ihm.menu.Menu;

/**
 * @author oleflohic
 */
public class PizzeriaAdminConsoleApp {

	// METHODES STATIQUES
	
	/**
	 * Méthode principale.
	 * @param args Arguments du programme.
	 */
	public static void main(String[] args) {
		
		// initialisations
		Scanner sc = new Scanner(System.in);
		
		/*
		int choix;
		MenuPizzeria menu = new MenuPizzeria (sc);

		// poursuivre jusqu'à ce que l'utilisateur demande de sortir
		do {

			// menu principal et lecture du choix, puis exécuter ce choix
			choix = menu.menuPrincipal ();
			menu.executerChoix(choix);
			
		} while (choix != 99);
		*/
		
		Menu menu = new Menu (sc);
		menu.afficher();
		
		
		// dernières opérations afin la fin du programme
		sc.close();
		

	}

}
