package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.ihm.menu.Menu;

/**
 * classe de point d'entr�e de l'application
 * @author oleflohic
 */
public class PizzeriaAdminConsoleApp {
	
	/**
	 * M�thode principale.
	 * @param args Arguments du programme.
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Menu menu = new Menu (sc, new PizzaDaoImpl());
		menu.afficher();
		
		sc.close();
		

	}

}
