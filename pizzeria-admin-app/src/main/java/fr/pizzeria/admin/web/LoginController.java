package fr.pizzeria.admin.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getParameter("deconnexion") != null) {
			request.getSession().setAttribute("connecte", false);
		}
		/*
		 * else if ("true".equals(""+request.getSession().getAttribute("connecte"))) {
			response.sendRedirect(getServletContext().getContextPath() + "/index.jsp");
		}
		*/

		//boolean connecte = (boolean)request.getSession().getAttribute("connecte");
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String identifiant = request.getParameter("identifiant");
		String motDePasse = request.getParameter("mot_de_passe");
		
		if ("true".equals(""+request.getSession().getAttribute("connecte"))) {
			response.sendRedirect(getServletContext().getContextPath() + "/index.jsp");
		} else if (identifiant.equals("admin@pizzeria.fr") && motDePasse.equals("admin")) {
			request.getSession().setAttribute("connecte", true);
			response.sendRedirect(getServletContext().getContextPath() + "/index.jsp");
		} else {
			request.getSession().setAttribute("connecte", false);
		}
		
		request.setAttribute("form", "get");
		getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		
		
	}

}
