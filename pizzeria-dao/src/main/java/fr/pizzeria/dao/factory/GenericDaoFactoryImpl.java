package fr.pizzeria.dao.factory;

import org.apache.commons.lang3.NotImplementedException;

import fr.pizzeria.dao.client.IClientDao;
import fr.pizzeria.dao.pizza.IPizzaDao;

public class GenericDaoFactoryImpl implements DaoFactory {
	
	private IPizzaDao pizzaDao;
	private IClientDao clientDao;
	
	public GenericDaoFactoryImpl(IPizzaDao pizzaDao, IClientDao clientDao) { // TODO ajouter ICommandeDao
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
	
	// TODO getters pour client et commande DAO
	
}
