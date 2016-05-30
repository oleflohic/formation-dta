package fr.pizzeria.admin.listener;

import javax.inject.Inject;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.jboss.resteasy.logging.Logger;

import fr.pizzeria.admin.metier.PizzaService;

@WebListener
public class InitDataListener implements ServletContextListener {
	
	private static final Logger LOG = Logger.getLogger(InitDataListener.class);
	
	@Inject private PizzaService pizzaService;

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// ajouter les pizzas ici...
		
	}
	
	
}
