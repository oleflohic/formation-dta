package fr.pizzeria.console;

import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;

import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.pizzeria.dao.factory.DaoFactory;
import fr.pizzeria.exception.dao.DaoException;
import fr.pizzeria.ihm.menu.MenuAdmin;

/**
 * classe de point d'entrée de l'application
 * @author oleflohic
 */
public class PizzeriaAdminConsoleApp {
	
	/**
	 * Méthode principale.
	 * @param args Arguments du programme.
	 * @throws ClassNotFoundException 
	 * @throws DaoException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, DaoException {
		
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.WARNING);
		
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String confString = bundle.getString("dao.impl");
		
		System.out.println("Implémentation : " + confString);
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {confString, "application-config.xml"})) {
			lancerMenu(context.getBean(Scanner.class), context.getBean(DaoFactory.class));
		} catch (BeansException e) {
			System.err.println("Erreur : l'implémentation '" + confString + "' n'a pas pu être chargée.");
			e.printStackTrace();
		}
		
	}
	
	public static void lancerMenu (Scanner sc, DaoFactory daoFactory) {
		MenuAdmin menu = new MenuAdmin (sc, daoFactory);
		menu.afficher();
	}
	
}
