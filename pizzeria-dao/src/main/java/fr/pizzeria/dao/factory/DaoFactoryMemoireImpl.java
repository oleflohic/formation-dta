package fr.pizzeria.dao.factory;

import fr.pizzeria.dao.client.IClientDao;
import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoImpl;

public class DaoFactoryMemoireImpl implements DaoFactory {
	
	
	
	@Override
	public IClientDao getClientDao() {
		
		//return new ClientDaoMemoireImpl();
		
		throw new UnsupportedOperationException();
	}
	
	@Override
	public IPizzaDao getPizzaDao() {
		return new PizzaDaoImpl();
	}

}
