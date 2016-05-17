package fr.pizzeria.ihm.menu.option;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import fr.pizzeria.dao.factory.DaoFactory;
import fr.pizzeria.model.Pizza;

public class AfficherPizzaLaPlusChereOptionMenu extends AbstractOptionMenu {

	// ==== Constantes ====
	
	public static final String LISTER_PIZZAS_PAR_CATEGORIE_LIBELLE_MENU = "Afficher la pizza la plus chère";
	

	// ==== Constructeurs ====
	
	public AfficherPizzaLaPlusChereOptionMenu(DaoFactory daoFactory) {
		super(LISTER_PIZZAS_PAR_CATEGORIE_LIBELLE_MENU, daoFactory);
	}

	
	// ==== Méthodes ====

	@Override
	public boolean executer() {
		
		System.out.println();
		System.out.println("Pizza la plus chère :");
		
		List<Pizza> pizzas = daoFactory.getPizzaDao().listePizzas();
		
		// aucune pizza : message d'information
		if (pizzas.size() == 0) {
			System.out.println("Il n'y a actuellement aucune pizza dans la base.");
		} else {
			pizzas.stream()
				.collect(Collectors.maxBy(Comparator.comparing(Pizza::getPrix)))
				.ifPresent(System.out::println);
			
		}

		// afficher le nombre de pizzas crées depuis le début. grammaire en bonus.
		if (Pizza.nbPizzas > 1) {
			System.out.println("------- " + Pizza.nbPizzas + " pizzas créées depuis l’initialisation du programme");
		} else {
			System.out.println("------- " + Pizza.nbPizzas + " pizza créée depuis l’initialisation du programme");
		}
		System.out.println();
		
		
		return true;
	}

}
