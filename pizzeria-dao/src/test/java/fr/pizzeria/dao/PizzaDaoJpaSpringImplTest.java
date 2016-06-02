package fr.pizzeria.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.model.Pizza;

@ContextConfiguration(classes = SpringJpaConfig.class)
public class PizzaDaoJpaSpringImplTest extends PizzaDaoTest {
	@Autowired
	public void setPizzaDao(@Qualifier("pizzaDaoJpaSpringImpl") IPizzaDao pizzaDao) {
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
