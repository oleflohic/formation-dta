package fr.pizzeria.model;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation utilisée sur les variables de la classe Pizza.
 * Indique si la variable en question doit être incluse dans la méthode toString().
 * @author oleflohic
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
public @interface ToString {
	public boolean uppercase() default false;
}
