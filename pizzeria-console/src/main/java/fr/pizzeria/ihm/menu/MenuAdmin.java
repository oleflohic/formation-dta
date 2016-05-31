package fr.pizzeria.ihm.menu;

import java.util.Scanner;

import fr.pizzeria.dao.factory.DaoFactory;
import fr.pizzeria.exception.dao.AjouterPizzaException;
import fr.pizzeria.exception.dao.DaoException;
import fr.pizzeria.exception.dao.ModifierPizzaException;
import fr.pizzeria.exception.dao.SupprimerPizzaException;
import fr.pizzeria.exception.ihm.ChoixMenuException;
import fr.pizzeria.ihm.menu.option.AfficherPizzaLaPlusChereOptionMenu;
import fr.pizzeria.ihm.menu.option.AjouterPizzaOptionMenu;
import fr.pizzeria.ihm.menu.option.ImporterDonneesOptionMenu;
import fr.pizzeria.ihm.menu.option.ListerPizzasOptionMenu;
import fr.pizzeria.ihm.menu.option.ListerPizzasParCategorieOptionMenu;
import fr.pizzeria.ihm.menu.option.ModifierPizzaOptionMenu;
import fr.pizzeria.ihm.menu.option.QuitterOptionMenu;
import fr.pizzeria.ihm.menu.option.SupprimerPizzaOptionMenu;

/**
 * Menu principal de l'application. Permet d'écouter les saisies clavier et d'exécuter les actions en conséquence.
 * @author oleflohic
 */
public class MenuAdmin extends AbstractMenu {
	
	// ==== Constantes =====
	
	public static final String MENU_TITRE_LIBELLE = "Application Pizzeria Console";
	
	// ==== Constructeurs ====
	
	/**
	 * Créer un menu console.
	 * @param scanner
	 * @param daoFactory
	 */
	public MenuAdmin (Scanner scanner, DaoFactory daoFactory) {
		super(MENU_TITRE_LIBELLE, scanner, daoFactory);
	}
	
	
	// ==== Méthodes ====
	
	@Override
	protected void initialiserOptionsMenu() {
		options.put (1, new ListerPizzasOptionMenu(daoFactory));
		options.put (2, new AjouterPizzaOptionMenu(daoFactory, scanner));
		options.put (3, new ModifierPizzaOptionMenu(daoFactory, scanner));
		options.put (4, new SupprimerPizzaOptionMenu(daoFactory, scanner));

		options.put (5, new ListerPizzasParCategorieOptionMenu(daoFactory));
		options.put (6, new AfficherPizzaLaPlusChereOptionMenu(daoFactory));
		
		options.put (7, new ImporterDonneesOptionMenu(daoFactory));
		
		options.put (99, new QuitterOptionMenu());
	}
	
	/**
	 * Afficher les options disponibles.
	 */
	public void afficher () {
		boolean continuer = true;
		
		while (continuer) {
			System.out.println("**** " + MENU_TITRE_LIBELLE + " ****");
			
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
