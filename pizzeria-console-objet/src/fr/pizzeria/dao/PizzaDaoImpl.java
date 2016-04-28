package fr.pizzeria.dao;

import fr.pizzeria.model.Pizza;

public class PizzaDaoImpl implements IPizzaDao {
	
	
	// VARIABLES
	
	private Pizza[] pizzas;
	
	
	// CONSTRUCTEURS
	
	public PizzaDaoImpl() {

		// pizzas existantes
		pizzas = new Pizza[] {
				new Pizza ("PEP", "Peperoni", 10),
				new Pizza ("MAR", "Margherita", 14),
				new Pizza ("REI", "La Reine", 11.5),
				new Pizza ("FRO", "La 4 fromages", 12),
				new Pizza ("CAN", "La cannibale", 12.5),
				new Pizza ("SAV", "La savoyarde", 13),
				new Pizza ("ORI", "L'orientale", 13.5),
				new Pizza ("IND", "L'indienne", 14),
			};
		
	}
	
	
	// METHODES
	
	@Override
	public Pizza[] listePizzas() {
		Pizza[] copie = new Pizza[pizzas.length];
		System.arraycopy(pizzas, 0, copie, 0, pizzas.length);
		return copie;
	}
	
	@Override
	public boolean ajouterPizza(Pizza nouvellePizza) {
		
		boolean codePris = codePizzaExiste (nouvellePizza.getCode());
		
		if (!codePris) {
			
			Pizza[] pizzasApresAjout = new Pizza[pizzas.length+1];
			// copier le contenu de la vieille liste dans la nouvelle,
			// puis mettre la nouvelle pizza à sa fin
			for (int i = 0 ; i < pizzas.length ; i++) {
				pizzasApresAjout[i] = pizzas[i];
			}
			pizzasApresAjout[pizzas.length] = nouvellePizza;
			pizzas = pizzasApresAjout;
			
		}
		
		
		return !codePris;
	}
	
	@Override
	public boolean modifierPizza(String codePizza, Pizza pizzaApresModification) {
		
		int indexTableau = obtenirIndexCodePizza(codePizza);
		
		if (indexTableau == -1) {
			return false;
		} else {
			pizzas[indexTableau] = pizzaApresModification;
			return true;
		}
	}
	
	@Override
	public boolean supprimerPizza(String codePizza) {
		
		Pizza[] pizzasApresSuppression = new Pizza[pizzas.length-1];
		int indexPizzaASupprimer = obtenirIndexCodePizza(codePizza);
		
		// créer un nouveau tableau qui ne contient pas l'élément supprimé
		if (indexPizzaASupprimer == 0) { // cas début de liste
			
			for (int i = 1 ; i < pizzas.length ; i++) {
				pizzasApresSuppression[i-1] = pizzas[i];
			}
			
		} else if (indexPizzaASupprimer == (pizzas.length - 1)) { // cas fin de liste

			for (int i = 0 ; i < pizzas.length-1 ; i++) {
				pizzasApresSuppression[i] = pizzas[i];
			}
			
		} else { // cas milieu de liste
			
			// avant l'index de la pizza supprimée
			for (int i = 0 ; i < indexPizzaASupprimer ; i++) {
				pizzasApresSuppression[i] = pizzas[i];
			}
			
			// après l'index
			for (int i = indexPizzaASupprimer+1 ; i < pizzas.length ; i++) {
				pizzasApresSuppression[i-1] = pizzas[i];
			}
			
		}
		
		// remplacement de la liste
		pizzas = pizzasApresSuppression;
		
		
		return true;
	}

	

	@Override
	public boolean codePizzaExiste(String codePizza) {
		return (obtenirIndexCodePizza(codePizza) != -1);
	}


	@Override
	public int obtenirIndexCodePizza(String codePizza) {
		for (int i = 0 ; i < pizzas.length ; i++) {
			if (pizzas[i].getCode().equals(codePizza)) {
				return i;
			}
		}
		return -1;
	}
	
	
	@Override
	public Pizza trouverPizza(String codePizza) {
		int index = obtenirIndexCodePizza(codePizza);
		if (index == -1) {
			return null;	
		} else {
			return pizzas[index].clone();
		}
	}
	

}
