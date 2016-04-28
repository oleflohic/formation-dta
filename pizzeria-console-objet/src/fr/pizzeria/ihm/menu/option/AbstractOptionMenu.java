package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;

/**
 * Option de menu avec un libellé et une action exécutable (via méthode).
 * @author oleflohic
 */
public abstract class AbstractOptionMenu {
	
	// ==== Variables ====
	
	/**
	 * Texte affiché pour décrire cette option.
	 */
	private String libelle;
	
	/**
	 * DAO gérant la carte à pizza. Peut être null.
	 */
	protected IPizzaDao pizzaDao;
	
	/**
	 * Lecteur d'entrées clavier. Peut être null.
	 */
	protected Scanner scanner;
	
	
	// ==== Constructeurs ====
	
	/**
	 * Créer une option "minimale" et qui n'a pas besoin de consulter la carte à pizza ou d'écouter les entrées clavier.
	 * @param libelle
	 */
	public AbstractOptionMenu(String libelle) {
		super();
		this.libelle = libelle;
	}
	
	/**
	 * Créer une option "passive", qui a accès à la carte à pizza, mais qui n'a pas besoin d'écouter les entrées clavier.
	 * @param libelle
	 * @param pizzaDao
	 */
	public AbstractOptionMenu(String libelle, IPizzaDao pizzaDao) {
		this(libelle);
		this.pizzaDao = pizzaDao;
	}
	
	/**
	 * Créer une option "active", qui a accès à la carte et peut écouter les entrées clavier.
	 * @param libelle
	 * @param pizzaDao
	 * @param scanner
	 */
	public AbstractOptionMenu(String libelle, IPizzaDao pizzaDao, Scanner scanner) {
		this(libelle, pizzaDao);
		this.scanner = scanner;
	}
	
	
	// ==== Méthodes ====
	
	/**
	 * Action exécutée quand cette option est sélectionnée.
	 * @return false si cette option provoque la sortie du programme.
	 */
	public abstract boolean executer ();
	
	
	// ==== Accesseurs ====
	
	public String getLibelle() {
		return libelle;
	}
	

}
