package fr.pizzeria.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-05-16T12:32:35.595+0200")
@StaticMetamodel(Pizza.class)
public class Pizza_ {
	public static volatile SingularAttribute<Pizza, Integer> id;
	public static volatile SingularAttribute<Pizza, String> code;
	public static volatile SingularAttribute<Pizza, String> nom;
	public static volatile SingularAttribute<Pizza, Double> prix;
	public static volatile SingularAttribute<Pizza, CategoriePizza> categorie;
}
