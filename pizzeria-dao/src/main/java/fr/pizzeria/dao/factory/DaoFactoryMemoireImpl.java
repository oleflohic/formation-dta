package fr.pizzeria.dao.factory;

import fr.pizzeria.dao.client.ClientDaoImpl;
import fr.pizzeria.dao.pizza.PizzaDaoImpl;

public class DaoFactoryMemoireImpl extends GenericDaoFactoryImpl {
	
	public DaoFactoryMemoireImpl () {
		super(new PizzaDaoImpl(), new ClientDaoImpl());
	}
	
}
