package fr.pizzeria.spring.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.model.Pizza;

@Controller
@RequestMapping("/pizzas")
public class PizzaController {
	
    @Autowired IPizzaDao pizzaDao;
    
	/*
	@RequestMapping(method = RequestMethod.GET)
	//@ResponseBody
	public String bonjour() {
		return "vuebonjour";
	}
	*/
    
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Pizza> listePizzas() {
        return pizzaDao.listePizzas();
	}
	
	
	
}