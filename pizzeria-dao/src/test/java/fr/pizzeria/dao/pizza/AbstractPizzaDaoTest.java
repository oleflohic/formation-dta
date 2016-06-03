package fr.pizzeria.dao.pizza;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.pizzeria.exception.dao.AjouterPizzaException;
import fr.pizzeria.exception.dao.ModifierPizzaException;
import fr.pizzeria.exception.dao.SupprimerPizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = SpringConfig.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public abstract class AbstractPizzaDaoTest {
	
	protected IPizzaDao pizzaDao;
	
	// listePizza
	
	@Test
	public void testListePizzas () {
		List<Pizza> pizzas = pizzaDao.listePizzas();
		Assert.assertNotNull(pizzas);
		Assert.assertEquals(PizzaDaoImpl.pizzasParDefaut().length, pizzas.size());
	}
	
	// ajouterPizza()
	
	@Test (expected = AjouterPizzaException.class)
	public void testAjouterPizza_CodeDejaPris () throws AjouterPizzaException {
		// code déjà pris
		pizzaDao.ajouterPizza(new Pizza("PEP", "Peperoni", new BigDecimal("10"), CategoriePizza.VIANDE, "'http://placehold.it/75x75'"));
		Assert.fail("code accepté bien que déjà pris");
	}
	
	@Test (expected = AjouterPizzaException.class)
	public void testAjouterPizza_CodeLongueurInvalide1 () throws AjouterPizzaException {
		// code de longueur invalide
		pizzaDao.ajouterPizza(new Pizza("AA", "---", new BigDecimal("0"), CategoriePizza.SANS_VIANDE, "'http://placehold.it/75x75'"));
		Assert.fail("code pizza de taille incorrecte (doit faire 3 caractères de long)");
	}
	
	@Test (expected = AjouterPizzaException.class)
	public void testAjouterPizza_CodeLongueurInvalide2 () throws AjouterPizzaException {
		pizzaDao.ajouterPizza(new Pizza("AAAA", "---", new BigDecimal("0"), CategoriePizza.SANS_VIANDE, "'http://placehold.it/75x75'"));
		Assert.fail("code pizza de taille incorrecte (doit faire 3 caractères de long)");
	}
	
	@Test
	public void testAjouterPizza_Valide () throws AjouterPizzaException {
		// code valide
		pizzaDao.ajouterPizza(new Pizza("AAA", "---", new BigDecimal("0"), CategoriePizza.SANS_VIANDE, "'http://placehold.it/75x75'"));
	}
	

	@Test (expected = AjouterPizzaException.class)
	public void testAjouterPizza_MemePizzaDeuxFois () throws AjouterPizzaException {
		pizzaDao.ajouterPizza(new Pizza("AAA", "---", new BigDecimal("0"), CategoriePizza.SANS_VIANDE, "'http://placehold.it/75x75'"));
		pizzaDao.ajouterPizza(new Pizza("AAA", "---", new BigDecimal("0"), CategoriePizza.SANS_VIANDE, "'http://placehold.it/75x75'"));
	}
	
	
	// modifierPizza()
	
	@Test(expected = ModifierPizzaException.class)
	public void testModifierPizza_VersCodeDejaPris () throws ModifierPizzaException {
		pizzaDao.modifierPizza("PEP", new Pizza("MAR", "---", new BigDecimal("0"), CategoriePizza.SANS_VIANDE,"'http://placehold.it/75x75'"));
		Assert.fail("modification autorisée vers code déjà pris");
	}

	@Test(expected = ModifierPizzaException.class)
	public void testModifierPizza_DontCodeIntrouvable () throws ModifierPizzaException {
		pizzaDao.modifierPizza("AAA", new Pizza("AAAA", "---", new BigDecimal("0"), CategoriePizza.SANS_VIANDE,"'http://placehold.it/75x75'"));
		Assert.fail("code non existant, mais modification autorisée ?");
	}

	@Test(expected = ModifierPizzaException.class)
	public void testModifierPizza_VersCodeLongueurInvalide () throws ModifierPizzaException {
		pizzaDao.modifierPizza("PEP", new Pizza("PEPE", "---", new BigDecimal("0"), CategoriePizza.SANS_VIANDE,"'http://placehold.it/75x75'"));
		Assert.fail("modification autorisée vers code de longueur incorrecte");
	}
	
	@Test
	public void testModifierPizza_VersMemeCode () throws ModifierPizzaException {
		pizzaDao.modifierPizza("PEP", new Pizza("PEP", "Toujours Peperoni", new BigDecimal("10"), CategoriePizza.VIANDE,"'http://placehold.it/75x75'"));
	}
	
	@Test
	public void testModifierPizza_Valide () throws ModifierPizzaException {
		pizzaDao.modifierPizza("PEP", new Pizza("AAA", "---", new BigDecimal("0"), CategoriePizza.SANS_VIANDE,"'http://placehold.it/75x75'"));
	}
	
	
	// supprimerPizza()
	
	@Test(expected = SupprimerPizzaException.class)
	public void testSupprimerPizza_CodeIntrouvable () throws SupprimerPizzaException {
		pizzaDao.supprimerPizza("AAA");
	}

	public void testSupprimerPizza_CodeValide () throws SupprimerPizzaException {
		pizzaDao.supprimerPizza("PEP");
		pizzaDao.supprimerPizza("MAR");
	}
	
	public void testSupprimerPizza_CodeNull () throws SupprimerPizzaException {
		pizzaDao.supprimerPizza(null);
	}
	
	

}
