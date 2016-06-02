package fr.pizzeria.admin.web.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.pizzeria.admin.metier.PizzaService;
import fr.pizzeria.model.Pizza;


/**
 * Servlet implementation class PizzaApi
 */

@Path("/rest/pizzas/")
public class PizzaResource {
	
	@Inject private PizzaService service;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pizza> listePizzas () {
		/*
		ResponseBuilder respBuilder = Response.ok();
		respBuilder.entity(service.listePizzas());
		respBuilder.header("Access-Control-Allow-Origin",  "http://127.0.0.1:80");
		return respBuilder.build();
		*/
		return service.listePizzas();
	}
	
	@POST
    @Consumes(MediaType.APPLICATION_JSON)
	public void ajouterPizza (Pizza pizza) {
		service.ajouterPizza(pizza);
	}
	
	@PUT
    @Consumes(MediaType.APPLICATION_JSON)
	public void modifierPizza (String code, Pizza pizza) {
		service.modifierPizza(code, pizza);
	}
	
	@DELETE
    @Consumes(MediaType.APPLICATION_JSON)
	public void supprimerPizza (String code) {
		//service.s
	}
	
}

