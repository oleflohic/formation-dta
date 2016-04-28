package fr.pizzeria.ihm.menu.option;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.Pizza;

public class ListerPizzasOptionMenu extends AbstractOptionMenu {

	// CONSTANTES
	
	public static final String LISTER_PIZZAS_LIBELLE_MENU = "Lister les pizzas";
	

	// CONSTRUCTEURS
	
	public ListerPizzasOptionMenu(IPizzaDao pizzaDao) {
		super(LISTER_PIZZAS_LIBELLE_MENU, pizzaDao);
	}

	
	// METHODES

	@Override
	public boolean executer() {
		
		System.out.println();
		System.out.println("Liste des pizzas :");
		
		Pizza[] pizzas = pizzaDao.listePizzas();
		
		// aucune pizza : message d'information
		if (pizzas.length == 0) {
			System.out.println("Il n'y a aucune pizza dans la base.");
		} else {
			
			for (Pizza p : pizzas) {
				System.out.println("" + p.getCode() + " -> " + p.getNom() + " (" + p.getPrix() + "�)");
			}
			
			// afficher le nombre de pizzas cr�es depuis le d�but. grammaire en bonus.
			if (Pizza.nbPizzas > 1) {
				System.out.println("------- " + Pizza.nbPizzas + " pizzas cr��es depuis l�initialisation du programme");
			} else {
				System.out.println("------- " + Pizza.nbPizzas + " pizza cr��e depuis l�initialisation du programme");
			}
			System.out.println();
		}
		
		
		return true;
	}

}