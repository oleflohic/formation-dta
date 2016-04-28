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
	 * M�thode principale.
	 * @param args Arguments du programme.
	 */
	public static void main(String[] args) {
		
		// initialisations
		Scanner sc = new Scanner(System.in);
		
		/*
		int choix;
		MenuPizzeria menu = new MenuPizzeria (sc);

		// poursuivre jusqu'� ce que l'utilisateur demande de sortir
		do {

			// menu principal et lecture du choix, puis ex�cuter ce choix
			choix = menu.menuPrincipal ();
			menu.executerChoix(choix);
			
		} while (choix != 99);
		*/
		
		Menu menu = new Menu (sc);
		menu.afficher();
		
		
		// derni�res op�rations afin la fin du programme
		sc.close();
		

	}

}
