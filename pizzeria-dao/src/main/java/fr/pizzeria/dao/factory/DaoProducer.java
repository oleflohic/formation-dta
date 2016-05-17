package fr.pizzeria.dao.factory;

import javax.persistence.EntityManagerFactory;

import fr.pizzeria.dao.client.ClientDaoJpaImpl;
import fr.pizzeria.dao.pizza.PizzaDaoBddImpl;
import fr.pizzeria.dao.pizza.PizzaDaoFichierImpl;
import fr.pizzeria.dao.pizza.PizzaDaoImpl;
import fr.pizzeria.dao.pizza.PizzaDaoJpaImpl;
import fr.pizzeria.exception.dao.DaoException;

public class DaoProducer {

	public DaoFactory getDaoFactoryJpa(EntityManagerFactory emf) throws DaoException {
		return new GenericFactoryImpl(new PizzaDaoJpaImpl(emf), new ClientDaoJpaImpl(emf));
	}
	
	public DaoFactory getDaoFactoryMemoire() {
		return new GenericFactoryImpl(new PizzaDaoImpl(), null);
	}
	
	public DaoFactory getDaoFactoryFichier() {
		return new GenericFactoryImpl(new PizzaDaoFichierImpl(), null);
	}
	
	public DaoFactory getDaoFactoryJdbc(String driver, String url, String user, String pass) throws DaoException {
		return new GenericFactoryImpl(new PizzaDaoBddImpl(driver, url, user, pass), null);
	}
}
