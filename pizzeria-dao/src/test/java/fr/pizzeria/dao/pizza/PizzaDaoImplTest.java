package fr.pizzeria.dao.pizza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;

import fr.pizzeria.config.dao.pizza.SpringConfig;

//@ContextConfiguration(classes = SpringConfig.class)
public class PizzaDaoImplTest extends AbstractPizzaDaoTest {
	@Autowired
	public void setPizzaDao(@Qualifier("pizzaDaoImpl") IPizzaDao pizzaDao) {
		this.pizzaDao = pizzaDao;
	}
}
