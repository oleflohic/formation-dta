package fr.pizzeria.dao;

import fr.pizzeria.model.Pizza;

public interface IPizzaDao {
	
	public Pizza[] listePizzas ();
	boolean ajouterPizza (Pizza newPizza);
	boolean modifierPizza (String codePizza, Pizza updatePizza);
	boolean supprimerPizza (String codePizza);
	
}
