package fr.pizzeria.ihm.menu.option;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import fr.pizzeria.dao.factory.DaoFactory;
import fr.pizzeria.model.Pizza;

public class ListerPizzasParCategorieOptionMenu extends AbstractOptionMenu {

	// ==== Constantes ====
	
	public static final String LISTER_PIZZAS_PAR_CATEGORIE_LIBELLE_MENU = "Lister les pizzas par catégories";
	

	// ==== Constructeurs ====
	
	public ListerPizzasParCategorieOptionMenu(DaoFactory daoFactory) {
		super(LISTER_PIZZAS_PAR_CATEGORIE_LIBELLE_MENU, daoFactory);
	}

	
	// ==== Méthodes ====

	@Override
	public boolean executer() {
		
		System.out.println();
		System.out.println("Liste des pizzas (par catégorie) :");
		
		
		List<Pizza> pizzas = daoFactory.getPizzaDao().listePizzas();
		
		// aucune pizza : message d'information
		if (pizzas.size() == 0) {
			System.out.println("Il n'y a actuellement aucune pizza dans la base.");
		} else {
			
			daoFactory.getPizzaDao().listePizzas().stream()
				.collect(Collectors.groupingBy(Pizza::getCategorie))
				.forEach((categorie,listePizzas) -> {
					System.out.println("+++" + categorie.getLibelle().toUpperCase() + "+++");
					listePizzas.stream()
						.sorted(Comparator.comparing(Pizza::getCode))
						.forEach(System.out::println);
					System.out.println();
				});
			
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
