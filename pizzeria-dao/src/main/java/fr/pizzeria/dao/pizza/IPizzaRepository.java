package fr.pizzeria.dao.pizza;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.pizzeria.model.Pizza;

@Repository
public interface IPizzaRepository extends JpaRepository<Pizza, Long> {
	
	//Pizza save (Pizza pizza);
	
}
