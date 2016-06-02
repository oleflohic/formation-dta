package fr.pizzeria.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.model.Pizza;

public class PizzaDaoJdbcTemplateImplTest extends PizzaDaoImplTest {

	@Autowired
	public void setPizzaDao(@Qualifier("pizzaDaoJdbcTemplateImpl") IPizzaDao pizzaDao) {
		this.pizzaDao = pizzaDao;
	}
	
	@Test
	@Override
	public void testListePizzas () {
		List<Pizza> pizzas = pizzaDao.listePizzas();
		Assert.assertNotNull(pizzas);
		Assert.assertEquals(11, pizzas.size());
	}
	
}
