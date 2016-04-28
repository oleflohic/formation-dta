package fr.pizzeria.ihm.menu.option;

import fr.pizzeria.dao.IPizzaDao;

public class ModifierPizzaOptionMenu extends AbstractOptionMenu {

	// CONSTANTES
	
	private static final String MODIFIER_PIZZA_LIBELLE_MENU = "Modifier une pizza";


	// CONSTRUCTEURS
	
	public ModifierPizzaOptionMenu(IPizzaDao pizzaDao) {
		super(MODIFIER_PIZZA_LIBELLE_MENU, pizzaDao);
	}


	// METHODES

	@Override
	public boolean executer() {
		// TODO Auto-generated method stub
		return true;
	}

}
