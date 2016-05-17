package fr.pizzeria.dao;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fr.pizzeria.dao.pizza.PizzaDaoImpl;
import fr.pizzeria.exception.dao.AjouterPizzaException;
import fr.pizzeria.exception.dao.ModifierPizzaException;
import fr.pizzeria.exception.dao.SupprimerPizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoImplTest {
	
	protected PizzaDaoImpl instance;
	
	@Before
	public void setUp () {
		instance = new PizzaDaoImpl ();
	}

	
	
	@Test
	public void testListePizzas () {
		
		List<Pizza> pizzas = instance.listePizzas();
		Assert.assertNotNull(pizzas);
		Assert.assertEquals(PizzaDaoImpl.pizzasParDefaut().length, pizzas.size());
		
	}
	
	// ajouterPizza()
	
	@Test (expected = AjouterPizzaException.class)
	public void testAjouterPizzaCodeDejaPris () throws AjouterPizzaException {
		// code d�j� pris
		instance.ajouterPizza(new Pizza("PEP", "Peperoni", new BigDecimal("10"), CategoriePizza.VIANDE));
		Assert.fail("code accepté bien que déjà pris");
	}
	
	@Test (expected = AjouterPizzaException.class)
	public void testAjouterPizzaCodeLongueurInvalide1 () throws AjouterPizzaException {
		// code de longueur invalide
		instance.ajouterPizza(new Pizza("AA", "---", new BigDecimal("0"), CategoriePizza.SANS_VIANDE));
		Assert.fail("code pizza de taille incorrecte (doit faire 3 caractères de long)");
	}
	
	@Test (expected = AjouterPizzaException.class)
	public void testAjouterPizzaCodeLongueurInvalide2 () throws AjouterPizzaException {
		instance.ajouterPizza(new Pizza("AAAA", "---", new BigDecimal("0"), CategoriePizza.SANS_VIANDE));
		Assert.fail("code pizza de taille incorrecte (doit faire 3 caractères de long)");
	}
	
	@Test
	public void testAjouterPizzaValide () throws AjouterPizzaException {
		// code valide
		instance.ajouterPizza(new Pizza("AAA", "---", new BigDecimal("0"), CategoriePizza.SANS_VIANDE));
	}
	

	@Test (expected = AjouterPizzaException.class)
	public void testAjouterMemePizzaDeuxFois () throws AjouterPizzaException {
		instance.ajouterPizza(new Pizza("AAA", "---", new BigDecimal("0"), CategoriePizza.SANS_VIANDE));
		instance.ajouterPizza(new Pizza("AAA", "---", new BigDecimal("0"), CategoriePizza.SANS_VIANDE));
	}
	
	
	// modifierPizza()
	
	@Test(expected = ModifierPizzaException.class)
	public void testModifierPizzaVersCodeDejaPris () throws ModifierPizzaException {
		instance.modifierPizza("PEP", new Pizza("MAR", "---", new BigDecimal("0"), CategoriePizza.SANS_VIANDE));
		Assert.fail("modification autorisée vers code déjà pris");
	}

	@Test(expected = ModifierPizzaException.class)
	public void testModifierPizzaDontCodeIntrouvable () throws ModifierPizzaException {
		instance.modifierPizza("AAA", new Pizza("AAAA", "---", new BigDecimal("0"), CategoriePizza.SANS_VIANDE));
		Assert.fail("code non existant, mais modification autorisée ?");
	}

	@Test(expected = ModifierPizzaException.class)
	public void testModifierPizzaVersCodeLongueurInvalide () throws ModifierPizzaException {
		instance.modifierPizza("PEP", new Pizza("PEPE", "---", new BigDecimal("0"), CategoriePizza.SANS_VIANDE));
		Assert.fail("modification autorisée vers code de longueur incorrecte");
	}
	
	@Test
	public void testModifierPizzaValide () throws ModifierPizzaException {
		instance.modifierPizza("PEP", new Pizza("AAA", "---", new BigDecimal("0"), CategoriePizza.SANS_VIANDE));
	}
	
	
	// supprimerPizza()
	
	@Test(expected = SupprimerPizzaException.class)
	public void testSupprimerPizzaCodeIntrouvable () throws SupprimerPizzaException {
		instance.supprimerPizza("AAA");
	}

	public void testSupprimerPizzaCodesValides () throws SupprimerPizzaException {
		instance.supprimerPizza("PEP");
		instance.supprimerPizza("MAR");
	}
	
	public void testSupprimerPizzaCodeNull () throws SupprimerPizzaException {
		instance.supprimerPizza(null);
	}
	
	

}
