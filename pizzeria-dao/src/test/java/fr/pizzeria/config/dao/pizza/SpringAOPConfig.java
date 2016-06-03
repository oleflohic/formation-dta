package fr.pizzeria.config.dao.pizza;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan({"fr.pizzeria.dao", "fr.pizzeria.aspects"})
@EnableAspectJAutoProxy
public class SpringAOPConfig {
}