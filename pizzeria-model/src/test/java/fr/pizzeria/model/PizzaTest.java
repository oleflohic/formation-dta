package fr.pizzeria.model;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PizzaTest {

	private Pizza pizza;
	
	@Before
	public void setUp() throws Exception {
		pizza = new Pizza();
	}

	@Test
	public void accesseurs_ValeursValides () {
		assert(pizza != null);

		pizza.setId(55);
		pizza.setCode("ABC");
		pizza.setNom("def");
		pizza.setPrix(new BigDecimal("72.34"));
		pizza.setCategorie(CategoriePizza.VIANDE);

		Assert.assertEquals(new Integer(55), pizza.getId());
		Assert.assertEquals("ABC", pizza.getCode());
		Assert.assertEquals("def", pizza.getNom());
		Assert.assertTrue(pizza.getPrix().compareTo(new BigDecimal("72.34")) == 0);
		Assert.assertEquals(CategoriePizza.VIANDE, pizza.getCategorie());
	}
	
	
	
}
