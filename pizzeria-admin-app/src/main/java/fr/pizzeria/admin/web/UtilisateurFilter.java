package fr.pizzeria.admin.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class UtilisateurFilter
 */
@WebFilter(urlPatterns = { "/pizzas/*" })
public class UtilisateurFilter implements Filter {
	
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		String connecte = "" + ((HttpServletRequest)request).getSession().getAttribute("connecte");
		
		// TODO remplacer ce bidouillage
		if ("null".equals(connecte) || "false".equals(connecte)) {
			
			// TODO réactiver pour forcer l'utilisateur a être connecté pour consulter la page 
			//((HttpServletResponse)response).sendRedirect(request.getServletContext().getContextPath() + "/login");
			
			chain.doFilter(request, response);
		} else {
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
