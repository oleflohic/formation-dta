package fr.pizzeria.ihm.menu.option;

import java.util.List;
import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.dao.ModifierPizzaException;
import fr.pizzeria.model.Pizza;

public class ModifierPizzaOptionMenu extends AbstractOptionMenu {

	// ==== Constantes ====
	
	private static final String MODIFIER_PIZZA_LIBELLE_MENU = "Modifier une pizza";


	// ==== Constructeurs ====
	
	public ModifierPizzaOptionMenu(IPizzaDao pizzaDao, Scanner scanner) {
		super(MODIFIER_PIZZA_LIBELLE_MENU, pizzaDao, scanner);
	}


	// ==== Méthodes ====

	@Override
	public boolean executer() throws ModifierPizzaException {
		
		List<Pizza> pizzas = pizzaDao.listePizzas();
		
		// aucune pizza : message d'information et sortie immédiate
		if (pizzas.size() == 0) {
			System.out.println("Il n'y a aucune pizza dans la base ; pas de mise-à-jour possible.");
			
		} else {
		
			// afficher la liste des pizzas
			for (Pizza p : pizzas) {
				System.out.println("" + p.getCode() + " -> " + p.getNom() + " (" + p.getPrix() + "€)");
			}
			
			// demander de sélectionner une pizza et lire la saisie clavier
			System.out.println("Veuillez choisir la pizza à modifier.\n(99 pour abandonner).");
			System.out.println("Code de la pizza à modifier : ");
			String codePizzaAMaj = scanner.next();
			
			// l'utilisateur abandonne la modification
			if (codePizzaAMaj.equals("99")) {
				System.out.println("Abandon de la mise-à-jour.");
				
			// sinon continuer les saisies
			} else {
				
				// cas d'erreur : code introuvable
				if (! pizzaDao.codePizzaExiste(codePizzaAMaj)) {
					System.out.println("Erreur : le code " + codePizzaAMaj + " est introuvable.");
				} else {

					
					// màj des infos
					System.out.print("Veuillez saisir le nouveau code : ");
					String codePizzaApresMaj = scanner.next();

					// cas d'erreur : code déjà pris
					if (pizzaDao.codePizzaExiste((codePizzaApresMaj))) {
						System.out.println("Erreur : le code " + codePizzaApresMaj + " est déjà pris.");

					// succès : saisie des autres infos et màj de la pizza
					} else {
					
						System.out.print("Veuillez saisir le nouveau nom : ");
						String nomPizzaApresMaj = scanner.next();
						
						System.out.print("Veuillez saisir le nouveau prix (utiliser , comme séparateur décimal) : ");
						float prixPizzaApresMaj = scanner.nextFloat();
						

						// TODO TEMPORAIRE ; peu efficace, mais permet d'être sûr que la pizza modifiée aura le même id
						// et n'augmentera pas le nombre de pizzas créées (valeur Pizza.nbPizzas)
						Pizza pizzaAModifier = pizzaDao.trouverPizza(codePizzaAMaj);
						pizzaDao.modifierPizza(codePizzaAMaj, new Pizza (pizzaAModifier.getId(), codePizzaApresMaj, nomPizzaApresMaj, prixPizzaApresMaj));
						
						/*
						try {

							// TODO TEMPORAIRE ; peu efficace, mais permet d'être sûr que la pizza modifiée aura le même id
							// et n'augmentera pas le nombre de pizzas créées (valeur Pizza.nbPizzas)
							Pizza pizzaAModifier = pizzaDao.trouverPizza(codePizzaAMaj);
							pizzaDao.modifierPizza(codePizzaAMaj, new Pizza (pizzaAModifier.getId(), codePizzaApresMaj, nomPizzaApresMaj, prixPizzaApresMaj));
							
						} catch (DaoException e) {
							System.out.println("Erreur : la pizza de code " + codePizzaAMaj + " n'a pas pu être ajoutée.");
						}
						*/
						
						
					}
					
					
				}
				
			}
		}
		
		return true;
	}

}
