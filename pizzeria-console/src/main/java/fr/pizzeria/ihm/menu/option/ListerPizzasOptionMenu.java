package fr.pizzeria.ihm.menu.option;

import java.util.Comparator;
import java.util.List;

import fr.pizzeria.dao.factory.DaoFactory;
import fr.pizzeria.model.Pizza;

public class ListerPizzasOptionMenu extends AbstractOptionMenu {

	// ==== Constantes ====
	
	public static final String LISTER_PIZZAS_LIBELLE_MENU = "Lister les pizzas";
	

	// ==== Constructeurs ====
	
	public ListerPizzasOptionMenu(DaoFactory daoFactory) {
		super(LISTER_PIZZAS_LIBELLE_MENU, daoFactory);
	}
	
	
	// ==== Méthodes ====

	@Override
	public boolean executer() {
		
		System.out.println();
		System.out.println("Liste des pizzas :");
		
		List<Pizza> pizzas = daoFactory.getPizzaDao().listePizzas();
		
		// aucune pizza : message d'information
		if (pizzas.size() == 0) {
			System.out.println("Il n'y a actuellement aucune pizza dans la base.");
		} else {
			pizzas.stream()
				.sorted(Comparator.comparing(Pizza::getCode))
				.forEach(pizzaActuelle -> System.out.println(pizzaActuelle));
		}

		// afficher le nombre de pizzas crééées depuis le début. grammaire en bonus.
		if (Pizza.nbPizzas > 1) {
			System.out.println("------- " + Pizza.nbPizzas + " pizzas créées depuis l'initialisation du programme");
		} else {
			System.out.println("------- " + Pizza.nbPizzas + " pizza créée depuis l'initialisation du programme");
		}
		System.out.println();
		
		
		return true;
	}

}
