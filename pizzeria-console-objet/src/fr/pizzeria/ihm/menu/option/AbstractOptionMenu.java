package fr.pizzeria.ihm.menu.option;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;

/**
 * Option de menu avec un libellé et une action exécutable (via méthode).
 * @author oleflohic
 *
 */
public abstract class AbstractOptionMenu {
	
	// VARIABLES
	
	private String libelle;
	protected IPizzaDao pizzaDao;
	protected Scanner scanner;
	
	
	// CONSTRUCTEURS
	
	public AbstractOptionMenu(String libelle) {
		super();
		this.libelle = libelle;
	}
	
	public AbstractOptionMenu(String libelle, IPizzaDao pizzaDao) {
		this(libelle);
		this.pizzaDao = pizzaDao;
	}
	
	public AbstractOptionMenu(String libelle, IPizzaDao pizzaDao, Scanner scanner) {
		this(libelle, pizzaDao);
		this.scanner = scanner;
	}
	
	
	// METHODES

	public abstract boolean executer ();

	
	// ACCESSEURS
	
	public String getLibelle() {
		return libelle;
	}
	

}
