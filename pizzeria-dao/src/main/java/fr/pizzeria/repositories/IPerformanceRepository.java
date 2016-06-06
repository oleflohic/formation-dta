package fr.pizzeria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.pizzeria.model.performance.Performance;


public interface IPerformanceRepository extends JpaRepository<Performance, Integer> {
	
}
