package fr.pizzeria.ihm.menu.option;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import fr.pizzeria.dao.admin.IPizzaDao;
import fr.pizzeria.dao.admin.PizzaDaoImpl;
import fr.pizzeria.exception.dao.DaoException;
import fr.pizzeria.ihm.menu.option.AjouterPizzaOptionMenu;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class AjouterPizzaOptionMenuTest {
	
	private AjouterPizzaOptionMenu optionMenu;
	private IPizzaDao pizzaDao;

	@Rule public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
	@Rule public final TextFromStandardInputStream systemInMock = TextFromStandardInputStream.emptyStandardInputStream();
	
	
	@Before
	public void setUp() throws Exception {
		Locale.setDefault(Locale.FRENCH); // Forcer le test unitaire à utiliser le format français pour la saisie des nombres décimaux
		Scanner scanner = new Scanner(System.in);
		pizzaDao = new PizzaDaoImpl();
		optionMenu = new AjouterPizzaOptionMenu (pizzaDao, scanner);	
	}

	@Test
	public void testExecuter() throws DaoException, IOException {
		systemInMock.provideLines("NEW", "NewPizza", "12,5", "VIANDE");
		boolean next = optionMenu.executer ();
		Assert.assertTrue(next);
		List<Pizza> allPizzas = pizzaDao.listePizzas();
		Optional<Pizza> pizzaOpt =
				allPizzas.stream().filter(p->"NEW".equals(p.getCode()))
				.findFirst();
		Assert.assertTrue(pizzaOpt.isPresent());
		Pizza pizza = pizzaOpt.get();
		Assert.assertEquals("NewPizza", pizza.getNom());
		Assert.assertEquals(new BigDecimal("12.5"), pizza.getPrix());
		Assert.assertEquals(CategoriePizza.VIANDE, pizza.getCategorie());
		
		String outAttendu = Files.lines(Paths.get("src/test/resources/resultatAjouterNouvellePizza.txt")).collect(Collectors.joining(System.lineSeparator()));
		outAttendu += System.lineSeparator();
		
		Assert.assertEquals(outAttendu, systemOutRule.getLog());
	}
	
}
