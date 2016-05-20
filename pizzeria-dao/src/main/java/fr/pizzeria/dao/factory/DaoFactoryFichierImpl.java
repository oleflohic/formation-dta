package fr.pizzeria.dao.factory;

import fr.pizzeria.dao.client.ClientDaoFichierImpl;
import fr.pizzeria.dao.pizza.PizzaDaoFichierImpl;

public class DaoFactoryFichierImpl extends GenericDaoFactoryImpl {
	
	public DaoFactoryFichierImpl () {
		super(new PizzaDaoFichierImpl(), new ClientDaoFichierImpl());
	}
	
}
