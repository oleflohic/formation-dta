package fr.pizzeria.dao.client;

import javax.persistence.EntityManagerFactory;

import fr.pizzeria.model.Client;

public class ClientDaoJpaImpl implements IClientDao {

	// ==== Variables ====
	
	/**
	 * 
	 */
	private EntityManagerFactory entityManagerFactory;
	
	
	// ==== Constructeurs ====
	public ClientDaoJpaImpl (EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}
	
	// ==== Méthodes ====
	
	
	@Override
	public void saveClient(Client client) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}
	
}
