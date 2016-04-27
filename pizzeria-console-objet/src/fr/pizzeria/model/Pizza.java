package fr.pizzeria.model;

public class Pizza {

	public static int nbPizzas;
	
	public int id;
	public String code;
	public String nom;
	public double prix;
	
	public Pizza (String code, String nom, double prix) {
		this.id = nbPizzas;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		
		nbPizzas++;
	}
	
}
