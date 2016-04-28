package fr.pizzeria.ihm.menu.option;

public class QuitterOptionMenu extends AbstractOptionMenu {
	
	// ==== Constantes ====
	
	public static final String QUITTER_LIBELLE_MENU = "Quitter";

	
	// ==== Constructeurs ====
	
	public QuitterOptionMenu() {
		super(QUITTER_LIBELLE_MENU);
	}
	
	
	// ==== Méthodes ====

	@Override
	public boolean executer() {
		System.out.println("Au revoir.");
		return false;
	}

}
