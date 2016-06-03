package fr.pizzeria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.pizzeria.model.Pizza;

@Repository
public interface IPizzaRepository extends JpaRepository<Pizza, Integer> {
	
	//Pizza save (Pizza pizza);
	
}
