package fr.pizzeria.console;

import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan({"fr.pizzeria", "java.util"})
public class PizzeriaAppSpringConfig {
	
	
	@Bean
	public Scanner scanner () {
		Scanner scanner = new Scanner (System.in);
		return scanner;
	}

}
