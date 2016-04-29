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


	// ==== M�thodes ====

	@Override
	public boolean executer() throws ModifierPizzaException {
		
		List<Pizza> pizzas = pizzaDao.listePizzas();
		
		// aucune pizza : message d'information et sortie imm�diate
		if (pizzas.size() == 0) {
			System.out.println("Il n'y a aucune pizza dans la base ; pas de mise-�-jour possible.");
			
		} else {
		
			// afficher la liste des pizzas
			for (Pizza p : pizzas) {
				System.out.println("" + p.getCode() + " -> " + p.getNom() + " (" + p.getPrix() + "�)");
			}
			
			// demander de s�lectionner une pizza et lire la saisie clavier
			System.out.println("Veuillez choisir la pizza � modifier.\n(99 pour abandonner).");
			System.out.println("Code de la pizza � modifier : ");
			String codePizzaAMaj = scanner.next();
			
			// l'utilisateur abandonne la modification
			if (codePizzaAMaj.equals("99")) {
				System.out.println("Abandon de la mise-�-jour.");
				
			// sinon continuer les saisies
			} else {
				
				// cas d'erreur : code introuvable
				if (! pizzaDao.codePizzaExiste(codePizzaAMaj)) {
					System.out.println("Erreur : le code " + codePizzaAMaj + " est introuvable.");
				} else {

					
					// m�j des infos
					System.out.print("Veuillez saisir le nouveau code : ");
					String codePizzaApresMaj = scanner.next();

					// cas d'erreur : code d�j� pris
					if (pizzaDao.codePizzaExiste((codePizzaApresMaj))) {
						System.out.println("Erreur : le code " + codePizzaApresMaj + " est d�j� pris.");

					// succ�s : saisie des autres infos et m�j de la pizza
					} else {
					
						System.out.print("Veuillez saisir le nouveau nom : ");
						String nomPizzaApresMaj = scanner.next();
						
						System.out.print("Veuillez saisir le nouveau prix (utiliser , comme s�parateur d�cimal) : ");
						float prixPizzaApresMaj = scanner.nextFloat();
						

						// TODO TEMPORAIRE ; peu efficace, mais permet d'�tre s�r que la pizza modifi�e aura le m�me id
						// et n'augmentera pas le nombre de pizzas cr��es (valeur Pizza.nbPizzas)
						Pizza pizzaAModifier = pizzaDao.trouverPizza(codePizzaAMaj);
						pizzaDao.modifierPizza(codePizzaAMaj, new Pizza (pizzaAModifier.getId(), codePizzaApresMaj, nomPizzaApresMaj, prixPizzaApresMaj));
						
						/*
						try {

							// TODO TEMPORAIRE ; peu efficace, mais permet d'�tre s�r que la pizza modifi�e aura le m�me id
							// et n'augmentera pas le nombre de pizzas cr��es (valeur Pizza.nbPizzas)
							Pizza pizzaAModifier = pizzaDao.trouverPizza(codePizzaAMaj);
							pizzaDao.modifierPizza(codePizzaAMaj, new Pizza (pizzaAModifier.getId(), codePizzaApresMaj, nomPizzaApresMaj, prixPizzaApresMaj));
							
						} catch (DaoException e) {
							System.out.println("Erreur : la pizza de code " + codePizzaAMaj + " n'a pas pu �tre ajout�e.");
						}
						*/
						
						
					}
					
					
				}
				
			}
		}
		
		return true;
	}

}
