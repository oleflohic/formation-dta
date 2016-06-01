package fr.pizzeria.dao.factory;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import fr.pizzeria.dao.pizza.PizzaDaoJdbcTemplateImpl;

public class DaoFactoryJdbcTemplate extends GenericDaoFactoryImpl {
	/*
	@Autowired
	private DataSource dataSource;
	*/
	
	public DaoFactoryJdbcTemplate() {
		super(null, null);
		//super(new PizzaDaoJdbcTemplate(null), null);
	}
	
}
