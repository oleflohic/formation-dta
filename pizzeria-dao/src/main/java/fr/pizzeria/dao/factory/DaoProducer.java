package fr.pizzeria.dao.factory;

import javax.persistence.EntityManagerFactory;

import fr.pizzeria.dao.client.ClientDaoFichierImpl;
import fr.pizzeria.dao.client.ClientDaoImpl;
import fr.pizzeria.dao.client.ClientDaoJpaImpl;
import fr.pizzeria.dao.pizza.PizzaDaoJdbcImpl;
import fr.pizzeria.dao.pizza.PizzaDaoFichierImpl;
import fr.pizzeria.dao.pizza.PizzaDaoImpl;
import fr.pizzeria.dao.pizza.PizzaDaoJpaImpl;
import fr.pizzeria.exception.dao.DaoException;

public class DaoProducer {
	public DaoFactory getDaoFactoryJpa(EntityManagerFactory emf) throws DaoException {
		return new GenericDaoFactoryImpl(new PizzaDaoJpaImpl(emf), new ClientDaoJpaImpl(emf));
	}
	
	public DaoFactory getDaoFactoryMemoire() {
		return new GenericDaoFactoryImpl(new PizzaDaoImpl(), new ClientDaoImpl());
	}
	
	public DaoFactory getDaoFactoryFichier() {
		return new GenericDaoFactoryImpl(new PizzaDaoFichierImpl(),  new ClientDaoFichierImpl());
	}
	
	public DaoFactory getDaoFactoryJdbc(String driver, String url, String user, String pass) throws DaoException {
		return new GenericDaoFactoryImpl(new PizzaDaoJdbcImpl(driver, url, user, pass), null);
	}
	
}
