package fr.pizzeria.spring.web.controller;


import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.exception.dao.AjouterPizzaException;
import fr.pizzeria.model.Pizza;

@RestController
@RequestMapping("/pizzas")
public class PizzaController {

    private static final Logger LOGGER = Logger.getLogger(PizzaController.class.getName());

    @Autowired IPizzaDao pizzaDao;

    public PizzaController() {
        LOGGER.log(Level.INFO, "Création du bean " + PizzaController.class);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Pizza> list() {
        return pizzaDao.listePizzas();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Pizza post(@RequestBody Pizza pizza) {
        try {
			pizzaDao.ajouterPizza(pizza);
		} catch (AjouterPizzaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
        return pizza;
    }

}
