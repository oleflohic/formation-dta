package fr.pizzeria.dao.factory;

import org.apache.commons.lang3.NotImplementedException;

import fr.pizzeria.dao.client.IClientDao;
import fr.pizzeria.dao.pizza.IPizzaDao;

public class GenericFactoryImpl implements DaoFactory {

	private IPizzaDao pizzaDao;
	private IClientDao clientDao;

	public GenericFactoryImpl(IPizzaDao pizzaDao, IClientDao clientDao) {
		super();
		this.pizzaDao = pizzaDao;
		this.clientDao = clientDao;
	}

	
	@Override
	public IPizzaDao getPizzaDao() {
		check(pizzaDao);
		return pizzaDao;
	}

	private void check(Object implementation) {
		if (implementation == null) {
			throw new NotImplementedException("Dao non implémenté");
		}
	}
	
	@Override
	public IClientDao getClientDao() {
		check(clientDao);
		return clientDao;
	}

}
