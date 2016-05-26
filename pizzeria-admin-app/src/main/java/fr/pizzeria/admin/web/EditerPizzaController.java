package fr.pizzeria.admin.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.metier.PizzaService;
import fr.pizzeria.model.Pizza;

/**
 * Servlet implementation class EditerPizzaController
 */
@WebServlet("/pizzas/edit")
public class EditerPizzaController extends HttpServlet {

	//private IPizzaDao pizzaDao = new PizzaDaoImpl();

	@Inject private PizzaService service;
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 7518832768442083759L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public EditerPizzaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String code = (String)request.getParameter("code");
		
		Pizza pizza = service.trouverPizza(code);
		if (pizza != null) {
			request.setAttribute("pizza", pizza);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/pizzas/editerPizza.jsp");
			dispatcher.forward(request, response);
		} else {
			response.sendError(400, "Le code pizza fourni '" + code + "' n'existe pas.");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		String ancienCode = request.getParameter("ancien_code");
		Pizza pizza = pizzaDao.trouverPizza(ancienCode);
		*/
		
		
		
		
	}

}
