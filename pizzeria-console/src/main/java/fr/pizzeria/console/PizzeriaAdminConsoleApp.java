package fr.pizzeria.console;

import java.util.ResourceBundle;
import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaoFichierImpl;
import fr.pizzeria.dao.PizzaDaoImpl;
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
		
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String confString = bundle.getString("dao.impl");
		Integer daoImplConf = Integer.valueOf(confString);
		
		Scanner sc = new Scanner(System.in);
		
		Menu menu;
		switch (daoImplConf) {
		case 0:
			System.out.println("Implémentation mémoire");
			menu = new Menu (sc, new PizzaDaoImpl());
			menu.afficher();
			break;
		case 1:
			System.out.println("Implémentation fichier");
			menu = new Menu (sc, new PizzaDaoFichierImpl());
			menu.afficher();
			break;
		default:
			System.err.println("Implémentation non reconnue dans le fichier \"application.properties\".");
		}
		
		sc.close();
		

	}

}
