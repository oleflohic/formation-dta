package fr.pizzeria.dao.factory;

import fr.pizzeria.dao.admin.IPizzaDao;
import fr.pizzeria.dao.client.IClientDao;

public interface DaoFactory {

	public IClientDao getClientDao ();
	
	public IPizzaDao getPizzaDao ();
	
	
	
}
