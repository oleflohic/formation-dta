package fr.pizzeria.model;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation utilis�e sur les variables de la classe Pizza.
 * Indique si la variable en question doit �tre incluse dans la m�thode toString().
 * @author oleflohic
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
public @interface ToString {
	public boolean uppercase() default false;
}
