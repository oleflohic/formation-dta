package fr.pizzeria.ihm.menu.option;

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
	
	
	// CONSTRUCTEURS
	
	public AbstractOptionMenu(String libelle) {
		super();
		this.libelle = libelle;
	}
	
	public AbstractOptionMenu(String libelle, IPizzaDao pizzaDao) {
		this(libelle);
		this.pizzaDao = pizzaDao;
	}
	
	
	// METHODES

	public abstract boolean executer ();

	
	// ACCESSEURS
	
	public String getLibelle() {
		return libelle;
	}
	

}
