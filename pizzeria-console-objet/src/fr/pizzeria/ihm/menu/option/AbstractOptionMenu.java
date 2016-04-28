package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;

/**
 * Option de menu avec un libell� et une action ex�cutable (via m�thode).
 * @author oleflohic
 */
public abstract class AbstractOptionMenu {
	
	// ==== Variables ====
	
	/**
	 * Texte affich� pour d�crire cette option.
	 */
	private String libelle;
	
	/**
	 * DAO g�rant la carte � pizza. Peut �tre null.
	 */
	protected IPizzaDao pizzaDao;
	
	/**
	 * Lecteur d'entr�es clavier. Peut �tre null.
	 */
	protected Scanner scanner;
	
	
	// ==== Constructeurs ====
	
	/**
	 * Cr�er une option "minimale" et qui n'a pas besoin de consulter la carte � pizza ou d'�couter les entr�es clavier.
	 * @param libelle
	 */
	public AbstractOptionMenu(String libelle) {
		super();
		this.libelle = libelle;
	}
	
	/**
	 * Cr�er une option "passive", qui a acc�s � la carte � pizza, mais qui n'a pas besoin d'�couter les entr�es clavier.
	 * @param libelle
	 * @param pizzaDao
	 */
	public AbstractOptionMenu(String libelle, IPizzaDao pizzaDao) {
		this(libelle);
		this.pizzaDao = pizzaDao;
	}
	
	/**
	 * Cr�er une option "active", qui a acc�s � la carte et peut �couter les entr�es clavier.
	 * @param libelle
	 * @param pizzaDao
	 * @param scanner
	 */
	public AbstractOptionMenu(String libelle, IPizzaDao pizzaDao, Scanner scanner) {
		this(libelle, pizzaDao);
		this.scanner = scanner;
	}
	
	
	// ==== M�thodes ====
	
	/**
	 * Action ex�cut�e quand cette option est s�lectionn�e.
	 * @return false si cette option provoque la sortie du programme.
	 */
	public abstract boolean executer ();
	
	
	// ==== Accesseurs ====
	
	public String getLibelle() {
		return libelle;
	}
	

}
