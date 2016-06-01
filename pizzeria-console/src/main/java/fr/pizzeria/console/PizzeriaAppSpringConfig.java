package fr.pizzeria.console;

import java.util.Scanner;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import fr.pizzeria.dao.factory.DaoFactory;
import fr.pizzeria.dao.factory.GenericDaoFactoryImpl;
import fr.pizzeria.dao.pizza.IPizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoJdbcTemplateImpl;

@Configuration
@ComponentScan("fr.pizzeria")
@EnableTransactionManagement
public class PizzeriaAppSpringConfig {
	
	
	@Bean
	public Scanner scanner () {
		return new Scanner (System.in);
	}

	
	@Bean
	public DaoFactory daoFactory(@Qualifier("pizzaDaoJdbcTemplateImpl") IPizzaDao pizzaDao) {
		return new GenericDaoFactoryImpl(pizzaDao, null);
	}

	
	@Bean
	public PizzaDaoJdbcTemplateImpl pizzaDaoJdbcTemplateImpl(@Qualifier("dataSource") DataSource dataSource) {
		return new PizzaDaoJdbcTemplateImpl(dataSource);
	}
	
	
	
	@Bean
	public PropertyPlaceholderConfigurer props () {
		PropertyPlaceholderConfigurer co = new PropertyPlaceholderConfigurer () ;
		co.setLocation(new ClassPathResource("jdbc.properties"));
		return co;
	}
	
	@Bean
	public EntityManagerFactory emf () {
		return Persistence.createEntityManagerFactory("pizzeria-pu");
	}
	
	@Bean
	public DataSource dataSource(@Value("${jdbc.url}") String url, @Value("${jdbc.username}") String user, @Value("${jdbc.password}") String motDePasse) {
		return new DriverManagerDataSource(url, user, motDePasse);
	}
	
	@Bean
	public PlatformTransactionManager txManager(DataSource dataSource) {
			return new DataSourceTransactionManager(dataSource);
	}
	
	

}
