package fr.pizzeria.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.pizzeria.dao.pizza.PizzaDaoJdbcTemplateImpl;
import fr.pizzeria.exception.dao.DaoException;
import fr.pizzeria.model.Pizza;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=PizzaDaoSpringTest.class)
public class PizzaDaoJdbcTemplateImplTest {
	
	//@Autowired private DaoFactory daoFactory;
	@Autowired private PizzaDaoJdbcTemplateImpl pizzaDaoJdbcTemplateImpl;
	
	@Test
	public void testListePizzas () throws DaoException {

		//List<Pizza> pizzas = daoFactory.getPizzaDao().listePizzas();
		List<Pizza> pizzas = pizzaDaoJdbcTemplateImpl.listePizzas();
		Assert.assertEquals(11, pizzas.size());
	}
	
}
