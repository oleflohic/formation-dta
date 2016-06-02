package fr.pizzeria.dao;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("fr.pizzeria")
@EnableTransactionManagement
public class SpringConfig {
	
	@Bean
	public DataSource dataSource () {
		return new EmbeddedDatabaseBuilder().
				setType(EmbeddedDatabaseType.H2).
				addScript("db-schema.sql").
				addScript("db-data.sql").
				build();
	}
	
	/*
	// définir ce bean n'est pas nécessaire, car la classe en question est déjà annotée avec @Repository et @Lazy ;
	// contrairement à la DataSource, qui est un fichier auquel le développeur n'a pas accès direct et ne peut donc pas directement annoter.
	@Bean
	public PizzaDaoJdbcTemplateImpl pizzaDaoJdbcTemplateImpl (@Qualifier("dataSource") DataSource dataSource) {
		return new PizzaDaoJdbcTemplateImpl(dataSource);
	}
	*/
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}

	
}
