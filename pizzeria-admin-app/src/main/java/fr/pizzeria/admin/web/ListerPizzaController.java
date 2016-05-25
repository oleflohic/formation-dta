package fr.pizzeria.admin.web;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoImpl;
import fr.pizzeria.model.Pizza;

/**
 * Servlet implementation class ListerPizzaController
 */
public class ListerPizzaController extends HttpServlet {

	private IPizzaDao pizzaDao = new PizzaDaoImpl();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4905709999688594242L;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListerPizzaController() {
		super();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean connecte = (boolean)request.getSession().getAttribute("connecte");
		
		if (connecte) {
			// récupération de la liste des pizzas, tri, puis mise en attribut de cette liste. Java s'occupe de la mapper ensuite.
			List<Pizza> pizzas = pizzaDao.listePizzas();
			
			pizzas.sort(new Comparator<Pizza> () {
				@Override
				public int compare(Pizza o1, Pizza o2) {
					return o1.getCode().compareTo(o2.getCode());
				}
			});
			
			request.setAttribute("listePizzas", pizzas);
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/pizzas/listerPizzas.jsp");
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect(getServletContext().getContextPath() + "/login");
		}
		
	}
	
}
