package fr.pizzeria.dao.factory;

import fr.pizzeria.dao.client.IClientDao;
import fr.pizzeria.dao.pizza.IPizzaDao;

public interface DaoFactory {

	public IClientDao getClientDao ();
	public IPizzaDao getPizzaDao ();
	
}
