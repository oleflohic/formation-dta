package fr.pizzeria.ihm.menu.option;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.Pizza;

public class ListerPizzasParCategorieOptionMenu extends AbstractOptionMenu {

	// ==== Constantes ====
	
	public static final String LISTER_PIZZAS_PAR_CATEGORIE_LIBELLE_MENU = "Lister les pizzas par catégories";
	

	// ==== Constructeurs ====
	
	public ListerPizzasParCategorieOptionMenu(IPizzaDao pizzaDao) {
		super(LISTER_PIZZAS_PAR_CATEGORIE_LIBELLE_MENU, pizzaDao);
	}

	
	// ==== Méthodes ====

	@Override
	public boolean executer() {
		
		System.out.println();
		System.out.println("Liste des pizzas (par catégorie) :");
		
		
		List<Pizza> pizzas = pizzaDao.listePizzas();
		
		// aucune pizza : message d'information
		if (pizzas.size() == 0) {
			System.out.println("Il n'y a actuellement aucune pizza dans la base.");
		} else {
		
			
			/*
			pizzas.stream()
				.sorted((pizza1, pizza2) -> pizza1.getCategorie().compareTo(pizza2.getCategorie()))
				.forEach(pizzaActuelle -> System.out.println(pizzaActuelle));
				*/
			
			pizzaDao.listePizzas().stream()
				.collect(Collectors.groupingBy(Pizza::getCategorie))
				.forEach((categorie,listePizzas) -> {
					System.out.println("+++" + categorie.getLibelle().toUpperCase() + "+++");
					listePizzas.stream()
						.sorted(Comparator.comparing(Pizza::getCode))
						.forEach(System.out::println);
					System.out.println();
				});
			
			/*
			for (Pizza p : pizzas) {
				//System.out.println("" + p.getCode() + " -> " + p.getNom() + " (" + p.getPrix() + "€)");
				System.out.println(p);
			}
			*/
			
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
