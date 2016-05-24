package fr.pizzeria.admin.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoImpl;
import fr.pizzeria.model.Pizza;

public class PizzaServletWeb extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6530108743869106581L;
	
	private IPizzaDao pizzaDao = new PizzaDaoImpl();
	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Pizza> pizzas = pizzaDao.listePizzas();
		String page = afficherPageListePizzas(pizzas);
		response.getWriter().write(page);
    }

    private String afficherPageListePizzas(List<Pizza> pizzas) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("<!doctype html>")
                .append("<html>")
                    .append("<head><title>Liste des pizzas</title></head>")
                    .append("<body>")
                        .append("<table>")
							.append("<tr>")
								.append("<td>ID</td>")
								.append("<td>CODE</td>")
								.append("<td>NOM</td>")
								.append("<td>IMAGE</td>")
								.append("<td>PRIX</td>")
							.append("</tr>");

        pizzas.forEach(p -> {
            sb.append("<tr>")
                    .append("<td>").append(p.getId()).append("</td>")
                    .append("<td>").append(p.getCode()).append("</td>")
                    .append("<td>").append(p.getNom()).append("</td>")
                    .append("<td><img src=\"").append(p.getUrlImage()).append("\"></td>")
                    .append("<td>").append(p.getPrix()).append("</td>")
                .append("<tr>");
        });

        sb.append("</table>");

        sb.append("</body>");
        sb.append("</html>");
        return sb.toString();
    }

}