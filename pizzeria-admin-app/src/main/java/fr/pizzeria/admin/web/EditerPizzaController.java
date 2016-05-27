package fr.pizzeria.admin.web;

import java.io.IOException;
import java.math.BigDecimal;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.metier.PizzaService;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * Servlet implementation class EditerPizzaController
 */
@WebServlet("/pizzas/edit")
public class EditerPizzaController extends HttpServlet {
	
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
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String code = (String)request.getParameter("code");
		
		if (code != null) {
			Pizza pizza = service.trouverPizza(code);
			if (pizza != null) {
				request.setAttribute("pizza", pizza);
				request.setAttribute("categories", CategoriePizza.values());
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/pizzas/editerPizza.jsp");
				dispatcher.forward(request, response);
			} else {
				response.sendError(400, "Le code pizza fourni '" + code + "' n'existe pas.");
			}
		} else {
			response.sendError(400, "Aucun code pizza n'a été fourni.");
		}
		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String ancienCode = (String)request.getParameter("ancien_code");
		String code = (String)request.getParameter("code");
		String nom = (String)request.getParameter("nom");
		String categorie = (String)request.getParameter("categorie");
		BigDecimal prix = new BigDecimal((String)request.getParameter("prix"));
		String urlImage = (String)request.getParameter("url_image");
		
		service.modifierPizza(ancienCode, new Pizza(code, nom, prix, CategoriePizza.valueOf(categorie), urlImage));
		
		response.sendRedirect(getServletContext().getContextPath() + "/pizzas/edit?code=" + code);
		
		
		
		/*
		String ancienCode = request.getParameter("ancien_code");
		Pizza pizza = pizzaDao.trouverPizza(ancienCode);
		*/
		
		
		
		
	}

}
