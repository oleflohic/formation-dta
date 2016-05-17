package fr.pizzeria.dao.factory;

import javax.persistence.EntityManagerFactory;

import fr.pizzeria.dao.admin.IPizzaDao;
import fr.pizzeria.dao.client.IClientDao;

public class GenericFactoryImpl implements DaoFactory {

	private IPizzaDao pizzaDao;
	private IClientDao clientDao;
	
	public GenericFactoryImpl (IPizzaDao pizzaDao, IClientDao clientDao) {
		
	}
	
	@Override
	public IClientDao getClientDao() {
		return clientDao;
	}

	@Override
	public IPizzaDao getPizzaDao() {
		return pizzaDao;
	}

}
