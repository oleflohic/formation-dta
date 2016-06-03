package fr.pizzeria.dao.pizza;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;

import fr.pizzeria.config.dao.pizza.SpringAOPConfig;
import fr.pizzeria.model.Pizza;

//@ContextConfiguration(classes = SpringJpaConfig.class)
@ContextConfiguration(classes = SpringAOPConfig.class)
public class PizzaDaoDataJpaImplTest extends AbstractPizzaDaoTest {
	@Autowired
	public void setPizzaDao(@Qualifier("pizzaDaoDataJpaImpl") IPizzaDao pizzaDao) {
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
