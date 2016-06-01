package fr.pizzeria.console;

import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.pizzeria.dao.pizza.PizzaDaoFichierImpl;
import fr.pizzeria.exception.dao.DaoException;
import fr.pizzeria.ihm.menu.MenuAdmin;

/**
 * classe de point d'entrée de l'application
 * @author oleflohic
 */
public class PizzeriaAdminConsoleApp {

	private static final Logger LOG = Logger.getLogger(PizzaDaoFichierImpl.class.toString());
	
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
		
		LOG.log(Level.INFO, "Implémentation : " + confString);
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PizzeriaAppSpringConfig.class)) {
			MenuAdmin menu = context.getBean(MenuAdmin.class);
			menu.afficher();
		}
		
	}
	
	
}
