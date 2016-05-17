package fr.pizzeria.dao.factory;

import fr.pizzeria.dao.admin.IPizzaDao;
import fr.pizzeria.dao.client.IClientDao;

public class DaoFactoryMemoireImpl implements DaoFactory {
	
	@Override
	public IClientDao getClientDao() {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public IPizzaDao getPizzaDao() {
		throw new UnsupportedOperationException();
	}

}
