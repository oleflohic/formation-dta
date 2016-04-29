package fr.pizzeria.ihm.menu.option;

import java.util.List;
import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.dao.SupprimerPizzaException;
import fr.pizzeria.model.Pizza;

public class SupprimerPizzaOptionMenu extends AbstractOptionMenu {

	// ==== Constantes ====
	
	private static final String SUPPRIMER_PIZZA_LIBELLE_MENU = "Supprimer une pizza";

	
	// ==== Constructeurs ====
	
	public SupprimerPizzaOptionMenu(IPizzaDao pizzaDao, Scanner scanner) {
		super(SUPPRIMER_PIZZA_LIBELLE_MENU, pizzaDao, scanner);
	}


	// ==== Méthodes ====

	@Override
	public boolean executer() throws SupprimerPizzaException {
		
		List<Pizza> pizzas = pizzaDao.listePizzas();
		
		// aucune pizza : message d'information et sortie immédiate
		if (pizzas.size() == 0) {
			System.out.println("Il n'y a aucune pizza dans la base ; pas de suppression possible.");
		} else {
			
			// afficher la liste des pizzas
			for (Pizza p : pizzas) {
				System.out.println("" + p.getCode() + " -> " + p.getNom() + " (" + p.getPrix() + "€)");
			}
			
			// demander de sélectionner une pizza et lire la saisie clavier
			System.out.println("Veuillez choisir la pizza à supprimer.\n(99 pour abandonner).");
			System.out.println("Code de la pizza à supprimer : ");
			String codePizzaASupprimer = scanner.next();
			
			// l'utilisateur abandonne la modification
			if (codePizzaASupprimer.equals("99")) {
				System.out.println("Abandon de la suppression.");
				
			// sinon continuer les saisies
			} else {

				pizzaDao.supprimerPizza(codePizzaASupprimer);
				/*
				try {
					pizzaDao.supprimerPizza(codePizzaASupprimer);
				} catch (DaoException e) {
					System.out.println("Erreur : le code " + codePizzaASupprimer + " est introuvable.");
				}
				*/
				
			}
		}
		
		return true;
	}

}
