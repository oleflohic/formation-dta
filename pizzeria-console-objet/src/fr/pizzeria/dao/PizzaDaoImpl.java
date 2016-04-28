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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifierPizza(String codePizza, Pizza pizzaApresModification) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supprimerPizza(String codePizza) {
		// TODO Auto-generated method stub
		return false;
	}

}
