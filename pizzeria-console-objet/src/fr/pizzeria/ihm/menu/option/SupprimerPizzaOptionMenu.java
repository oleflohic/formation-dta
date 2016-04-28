package fr.pizzeria.ihm.menu.option;

import fr.pizzeria.dao.IPizzaDao;

public class SupprimerPizzaOptionMenu extends AbstractOptionMenu {

	// CONSTANTES
	
	private static final String SUPPRIMER_PIZZA_LIBELLE_MENU = "Supprimer une pizza";

	
	// CONSTRUCTEURS
	
	public SupprimerPizzaOptionMenu(IPizzaDao pizzaDao) {
		super(SUPPRIMER_PIZZA_LIBELLE_MENU, pizzaDao);
	}


	// METHODES

	@Override
	public boolean executer() {
		// TODO Auto-generated method stub
		return true;
	}

}
