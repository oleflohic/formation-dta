package fr.pizzeria.ihm.menu;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.pizzeria.dao.factory.DaoFactory;
import fr.pizzeria.exception.dao.AjouterPizzaException;
import fr.pizzeria.exception.dao.DaoException;
import fr.pizzeria.exception.dao.ModifierPizzaException;
import fr.pizzeria.exception.dao.SupprimerPizzaException;
import fr.pizzeria.exception.ihm.ChoixMenuException;
import fr.pizzeria.ihm.menu.option.AbstractOptionMenu;

@Component
public abstract class AbstractMenu {
	
	protected Map<Integer, AbstractOptionMenu> options = new TreeMap<>();
	
	/**
	 * Lecteur de saisies clavier.
	 */
	@Autowired
	protected Scanner scanner;
	
	@Autowired
	protected DaoFactory daoFactory;
	
	
	protected String titre;
	
	public AbstractMenu(String titre, Scanner sc, DaoFactory daoFactory) {
		super();
		this.titre = titre;
		this.daoFactory = daoFactory;
		this.scanner = sc;
		initialiserOptionsMenu();
	}
	
	protected abstract void initialiserOptionsMenu();
	
	public void afficher() {
		boolean continuer = true;
		
		while (continuer) {
			System.out.println("**** " + titre + " ****");
			
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