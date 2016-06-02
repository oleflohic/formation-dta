package fr.pizzeria.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import fr.pizzeria.dao.pizza.IPizzaDao;

public class PizzaDaoImplTest extends PizzaDaoTest {
	@Autowired
	public void setPizzaDao(@Qualifier("pizzaDaoImpl") IPizzaDao pizzaDao) {
		this.pizzaDao = pizzaDao;
	}
}
