package fr.pizzeria.admin.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* @WebFilter("/*") */
public class AuthentificationFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) req;
		HttpServletResponse httpReponse = (HttpServletResponse) resp;
		String emailAuthentifie = (String) httpRequest.getSession(true).getAttribute("email");
		
		//if (!httpRequest.getRequestURI().contains("/api") &&& !httpRequest.getRequestURI().contains("/login" && emailAuthentifie
		/*
		if ( 1 == 2 ) {
			httpResponse.sendRedirect(httpRequest.getServletContext().getContextPath() + AuthentificationController.URL);
		} else {
			chain.doFilter(req,resp);
		}
		*/
		
		

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
