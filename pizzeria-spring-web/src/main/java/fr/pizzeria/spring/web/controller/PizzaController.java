package fr.pizzeria.spring.web.controller;


import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.model.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        return pizzaDao.findAllPizzas();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Pizza post(@RequestBody Pizza pizza) {
        pizzaDao.savePizza(pizza);
        return pizza;
    }

}
