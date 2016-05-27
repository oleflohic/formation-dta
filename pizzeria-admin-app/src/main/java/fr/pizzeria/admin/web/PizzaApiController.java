package fr.pizzeria.admin.web;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.pizzeria.admin.metier.PizzaService;
import fr.pizzeria.model.Pizza;


/**
 * Servlet implementation class PizzaApi
 */

@Path("/rest/pizzas/")
public class PizzaApiController {
	
	@Inject private PizzaService service;
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pizza> listePizzas () {
		return service.listePizzas();
	}
	
	@POST
	public void ajouterPizza () {
		
	}

	

}

