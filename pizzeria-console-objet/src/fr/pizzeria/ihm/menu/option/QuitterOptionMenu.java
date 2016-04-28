package fr.pizzeria.ihm.menu.option;

public class QuitterOptionMenu extends AbstractOptionMenu {
	
	// CONSTANTES
	
	public static final String QUITTER_LIBELLE_MENU = "Quitter";

	
	// CONSTRUCTEURS
	
	public QuitterOptionMenu() {
		super(QUITTER_LIBELLE_MENU);
	}
	
	
	// METHODES

	@Override
	public boolean executer() {
		System.out.println("Au revoir.");
		return false;
	}

}
