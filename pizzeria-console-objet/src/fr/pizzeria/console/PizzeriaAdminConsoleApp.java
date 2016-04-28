package fr.pizzeria.console;

import java.util.Scanner;

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
		MenuPizzeria menu = new MenuPizzeria (sc);
		int choix;

		// poursuivre jusqu'� ce que l'utilisateur demande de sortir
		do {

			// menu principal et lecture du choix, puis ex�cuter ce choix
			choix = menu.menuPrincipal ();
			menu.executerChoix(choix);
			
		} while (choix != 99);
		
		// derni�res op�rations afin la fin du programme
		sc.close();

	}

}
