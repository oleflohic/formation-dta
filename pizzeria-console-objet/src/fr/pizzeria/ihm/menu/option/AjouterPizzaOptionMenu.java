package fr.pizzeria.ihm.menu.option;

import fr.pizzeria.dao.IPizzaDao;

public class AjouterPizzaOptionMenu extends AbstractOptionMenu {

	// CONSTANTES
	
	private static final String AJOUTER_PIZZA_LIBELLE_MENU = "Ajouter une pizza";


	// CONSTRUCTEURS
	
	public AjouterPizzaOptionMenu(IPizzaDao pizzaDao) {
		super(AJOUTER_PIZZA_LIBELLE_MENU, pizzaDao);
	}

	@Override
	public boolean executer() {
		// TODO Auto-generated method stub
		return true;
	}

}
