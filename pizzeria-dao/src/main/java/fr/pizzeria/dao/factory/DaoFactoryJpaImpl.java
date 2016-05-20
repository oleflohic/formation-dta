package fr.pizzeria.dao.factory;

public class DaoFactoryJpaImpl extends GenericDaoFactoryImpl {

	public DaoFactoryJpaImpl() {
		super(null, null); // TODO
		//super(new PizzaDaoJpaImpl(), new ClientDaoJpaImpl());
	}

}
