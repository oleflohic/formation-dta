package fr.pizzeria.model;

/**
 * Classe utilisée pour stocker les informations de pizza.
 * @author oleflohic
 * 
 */
public class Pizza {

	public static int nbPizzas;
	
	// VARIABLES
	
	private int id;
	private String code;
	private String nom;
	private double prix;
	
	
	// CONSTRUCTEURS
	
	public Pizza (String code, String nom, double prix) {
		this (nbPizzas, code, nom, prix);
		
		nbPizzas++;
	}
	
	public Pizza (int id, String code, String nom, double prix) {

		this.id = id;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		
	}
	
	// METHODES
	
	public Pizza clone () {
		return new Pizza (id, code, nom, prix);
		
	}
	
	
	// ACCESSEURS


	public int getId() {
		return id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public static int getNbPizzas() {
		return nbPizzas;
	}

	
}
