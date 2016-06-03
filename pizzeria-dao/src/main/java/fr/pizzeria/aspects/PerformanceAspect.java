package fr.pizzeria.aspects;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import fr.pizzeria.model.performance.Performance;
import fr.pizzeria.repositories.IPerformanceRepository;


@Aspect
@Component
public class PerformanceAspect {

	@Autowired
	private IPerformanceRepository repository;
	
	@Around("execution(* fr.pizzeria.dao.pizza.IPizzaDao.*(..))")
	public Object mesurerPerformance(ProceedingJoinPoint pjp) throws Throwable {
		
        Performance perf = new Performance ();
		
		StopWatch sw = new StopWatch();
		
		perf.setDate(new Date());
		sw.start();
        
        Object retVal = pjp.proceed();
        
        sw.stop();
        
        perf.setService(pjp.getSignature().toString());
        perf.setTempsExecution((int)sw.getTotalTimeMillis());
        
        repository.saveAndFlush(perf);
        
        return retVal;
        
    }
	
}
