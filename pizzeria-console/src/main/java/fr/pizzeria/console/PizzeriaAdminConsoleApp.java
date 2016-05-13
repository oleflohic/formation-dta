package fr.pizzeria.console;

import java.util.ResourceBundle;
import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaDaoBddImpl;
import fr.pizzeria.dao.PizzaDaoFichierImpl;
import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.exception.dao.DaoException;
import fr.pizzeria.ihm.menu.Menu;

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
		
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String confString = bundle.getString("dao.impl");
		Integer daoImplConf = Integer.valueOf(confString);
		
		Scanner sc = new Scanner(System.in);
		
		switch (daoImplConf) {
		case 0:
			System.out.println("Implémentation mémoire");
			lancerMenu(sc, new PizzaDaoImpl());
			break;
		case 1:
			System.out.println("Implémentation fichier");
			lancerMenu(sc, new PizzaDaoFichierImpl());
			break;
		case 2:
			System.out.println("Implémentation SQL");

			ResourceBundle jdbcBundle = ResourceBundle.getBundle("jdbc");
			
			lancerMenu(sc,
					new PizzaDaoBddImpl(jdbcBundle.getString("jdbc.driver"), 
						"jdbc:" + jdbcBundle.getString("jdbc.dbtype") + "://" + jdbcBundle.getString("jdbc.host") + ":"
								+ jdbcBundle.getString("jdbc.port") + "/" + jdbcBundle.getString("jdbc.dbname"),
						jdbcBundle.getString("jdbc.username"),
						jdbcBundle.getString("jdbc.password")
					));
			
			break;
		default:
			System.err.println("Implémentation non reconnue dans le fichier \"application.properties\".");
		}
		
		sc.close();
		
	}
	

	
	public static void lancerMenu (Scanner sc, IPizzaDao dao) {
		Menu menu = new Menu (sc, dao);
		menu.afficher();
	}
	

}
