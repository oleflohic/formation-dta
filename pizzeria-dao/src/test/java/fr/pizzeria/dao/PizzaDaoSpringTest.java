package fr.pizzeria.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import fr.pizzeria.dao.pizza.PizzaDaoJdbcTemplateImpl;

public class PizzaDaoSpringTest {
	
	@Bean
	public DataSource dataSource () {
		return new EmbeddedDatabaseBuilder().
				setType(EmbeddedDatabaseType.H2).
				addScript("db-schema.sql").
				addScript("db-data.sql").
				build();
	}
	
	@Bean
	public PizzaDaoJdbcTemplateImpl pizzaDaoJdbcTemplateImpl (@Qualifier("dataSource") DataSource dataSource) {
		return new PizzaDaoJdbcTemplateImpl(dataSource);
	}
	
}
