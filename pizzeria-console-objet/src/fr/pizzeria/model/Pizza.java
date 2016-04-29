package fr.pizzeria.model;

/**
 * Classe utilis�e pour stocker les informations de pizza.
 * @author oleflohic
 */
public class Pizza {

	/**
	 * Nombre de (nouvelles) pizzas qui ont �t� cr��es depuis le d�but du programme.
	 */
	public static int nbPizzas;
	
	// ==== Variables ====
	
	/**
	 * Identifiant unique de la pizza. N'est pas forc�ment �gal � l'index de valeur si stock� dans un tableau.
	 */
	private int id;
	
	/**
	 * Code pizza en 3 caract�res. Unique.
	 */
	private String code;
	
	/**
	 * Nom affich� de la pizza.
	 */
	private String nom;
	
	/**
	 * Prix de la pizza.
	 */
	private double prix;
	
	
	// ==== Constructeurs ====
	
	/**
	 * Cr�e une nouvelle instance de pizza avec id unique.
	 * @param code
	 * @param nom 
	 * @param prix
	 */
	public Pizza (String code, String nom, double prix) {
		this (nbPizzas, code, nom, prix);
		nbPizzas++;
	}
	
	/**
	 * Cr�e une instance de pizza dont l'id a �t� pr�cis�. N'incr�mente pas nbPizzas.
	 * @param id
	 * @param code
	 * @param nom
	 * @param prix
	 */
	public Pizza (int id, String code, String nom, double prix) {
		this.id = id;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
	}
	
	// ==== M�thodes ====
	
	/**
	 * Cloner cette pizza.
	 */
	public Pizza clone () {
		return new Pizza (id, code, nom, prix);
		
	}

	/*
	@Override
	public int compareTo(Object arg0) {
		if (arg0 instanceof Pizza) {
			Pizza autre = (Pizza)arg0;
			return autre.code.compareTo(this.code);
		} else {
			return 0;
		}
	}
	*/
	
	// ==== Accesseurs ====


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
