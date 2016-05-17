package fr.pizzeria.model;

import java.sql.Time;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-05-17T11:56:04.194+0200")
@StaticMetamodel(Commande.class)
public class Commande_ {
	public static volatile SingularAttribute<Commande, Integer> id;
	public static volatile SingularAttribute<Commande, Integer> numeroCommande;
	public static volatile SingularAttribute<Commande, String> status;
	public static volatile SingularAttribute<Commande, Time> dateCommande;
	public static volatile SingularAttribute<Commande, Livreur> livreur;
	public static volatile SingularAttribute<Commande, Client> client;
}
