package fr.pizzeria.model;

/**
 * Classe utilisée pour stocker les informations de pizza.
 * @author oleflohic
 * 
 */
public class Pizza {

	public static int nbPizzas;
	
	public int id;
	public String code;
	public String nom;
	public double prix;
	
	
	public static Pizza creerObjetPizza (String code, String nom, double prix) {
		
		Pizza nouvellePizza = new Pizza ();
		nouvellePizza.id = nbPizzas;
		nouvellePizza.code = code;
		nouvellePizza.nom = nom;
		nouvellePizza.prix = prix;
		
		nbPizzas++;
		
		return nouvellePizza;
		
	}
	
}
