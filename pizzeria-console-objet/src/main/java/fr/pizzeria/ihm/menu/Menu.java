package fr.pizzeria.ihm.menu;

import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.dao.AjouterPizzaException;
import fr.pizzeria.exception.dao.DaoException;
import fr.pizzeria.exception.dao.ModifierPizzaException;
import fr.pizzeria.exception.dao.SupprimerPizzaException;
import fr.pizzeria.exception.ihm.ChoixMenuException;
import fr.pizzeria.ihm.menu.option.AbstractOptionMenu;
import fr.pizzeria.ihm.menu.option.AfficherPizzaLaPlusChereOptionMenu;
import fr.pizzeria.ihm.menu.option.AjouterPizzaOptionMenu;
import fr.pizzeria.ihm.menu.option.ListerPizzasOptionMenu;
import fr.pizzeria.ihm.menu.option.ListerPizzasParCategorieOptionMenu;
import fr.pizzeria.ihm.menu.option.ModifierPizzaOptionMenu;
import fr.pizzeria.ihm.menu.option.QuitterOptionMenu;
import fr.pizzeria.ihm.menu.option.SupprimerPizzaOptionMenu;

/**
 * Menu principal de l'application. Permet d'écouter les saisies clavier et d'exécuter les actions en conséquence.
 * @author oleflohic
 */
public class Menu {
	
	// ==== Constantes =====
	
	public static final String MENU_TITRE_LIBELLE = "Application Pizzeria Console";
	
	
	// ==== Variables =====
	
	/**
	 * Liste des options disponibles à l'utilisateur.
	 */
	private Map<Integer,AbstractOptionMenu> options;
	
	/**
	 * Lecteur de saisies clavier.
	 */
	private Scanner scanner;
	
	
	// ==== Constructeurs ====
	
	/**
	 * Créer un menu console.
	 * @param scanner
	 */
	public Menu (Scanner scanner, IPizzaDao pizzaDao) {
		initialiserOptions (scanner, pizzaDao);
		this.scanner = scanner;
	}
	
	
	// ==== Méthodes ====
	
	/**
	 * Initialiser le menu en définissant des options.
	 * @param scanner
	 * @param pizzaDao
	 */
	public void initialiserOptions (Scanner scanner, IPizzaDao pizzaDao) {
		options = new TreeMap<Integer, AbstractOptionMenu> (new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		});
		
		options.put (1, new ListerPizzasOptionMenu(pizzaDao));
		options.put (2, new AjouterPizzaOptionMenu(pizzaDao, scanner));
		options.put (3, new ModifierPizzaOptionMenu(pizzaDao, scanner));
		options.put (4, new SupprimerPizzaOptionMenu(pizzaDao, scanner));

		options.put (5, new ListerPizzasParCategorieOptionMenu(pizzaDao));
		options.put (6, new AfficherPizzaLaPlusChereOptionMenu(pizzaDao));
		
		options.put (99, new QuitterOptionMenu());
	}
	
	/**
	 * Afficher les options disponibles.
	 */
	public void afficher () {
		boolean continuer = true;
		
		while (continuer) {
			System.out.println("**** " + MENU_TITRE_LIBELLE + " ****");
			
			/*
			Set<Entry<Integer, AbstractOptionMenu>> es = options.entrySet();
			for (Entry<Integer, AbstractOptionMenu> e : es) {
				System.out.println("" + e.getKey() + ". " + e.getValue().getLibelle());
			}
			*/
			
			/*
			options.entrySet().stream()
				.forEach(
					optionMenuEntry ->
					System.out.println(optionMenuEntry.getKey() + ". " + optionMenuEntry.getValue().getLibelle())
			);
			*/

			
			options.forEach((cle, valeur) -> System.out.println(cle + ". " + valeur.getLibelle()));
			
			
			try {
				int saisie = scanner.nextInt();
				if (options.containsKey(saisie)) {
					continuer = options.get(saisie).executer();
				} else {
					throw new ChoixMenuException ("Erreur : Le choix " + saisie + " n'est pas reconnu.");
				}
			} catch (AjouterPizzaException e) {
				System.out.println("Échec de l'ajout de pizza : " + e.getMessage());
			} catch (ModifierPizzaException e) {
				System.out.println("Échec de la modification de pizza : " + e.getMessage());
			} catch (SupprimerPizzaException e) {
				System.out.println("Échec de la suppression de pizza : " + e.getMessage());
			} catch (DaoException e) {
				System.out.println("Échec de l'opération : " + e.getMessage());
			} catch (ChoixMenuException e) {
				System.out.println(e.getMessage());
			}
			System.out.println();
		}
		
	}
	
}
