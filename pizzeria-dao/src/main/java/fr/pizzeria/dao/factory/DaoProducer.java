package fr.pizzeria.dao.factory;

import javax.persistence.EntityManagerFactory;

public class DaoProducer {
	
	public DaoFactory getDaoFactoryJpa (EntityManagerFactory emf) {

		throw new UnsupportedOperationException();
		//return null;
	}
	
	public DaoFactory getDaoFactoryMemoire () {
		return null;
	}
	
}
