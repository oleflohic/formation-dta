package fr.pizzeria.model;

import java.util.Arrays;
import java.util.stream.Collectors;

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
	@ToString
	private String code;
	
	/**
	 * Nom affich� de la pizza.
	 */
	@ToString
	private String nom;
	
	/**
	 * Prix de la pizza.
	 */
	@ToString
	private double prix;
	
	/**
	 * Cat�gorie de la pizza.
	 */
	@ToString
	private CategoriePizza categorie;
	
	
	// ==== Constructeurs ====
	
	/**
	 * Cr�e une nouvelle instance de pizza avec id unique.
	 * @param code
	 * @param nom 
	 * @param prix
	 * @param categorie
	 */
	public Pizza (String code, String nom, double prix, CategoriePizza categorie) {
		this (nbPizzas, code, nom, prix, categorie);
		nbPizzas++;
	}
	
	/**
	 * Cr�e une instance de pizza dont l'id a �t� pr�cis�. N'incr�mente pas nbPizzas.
	 * @param id
	 * @param code
	 * @param nom
	 * @param prix
	 * @param categorie
	 */
	public Pizza (int id, String code, String nom, double prix, CategoriePizza categorie) {
		this.id = id;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.categorie = categorie;
	}
	
	// ==== M�thodes ====
	
	/**
	 * Cloner cette pizza.
	 */
	public Pizza clone () {
		return new Pizza (id, code, nom, prix, categorie);
		
	}
	
	/**
	 * Informations de la pizza affich�es
	 */
	@Override
	public String toString () {
		
		//return "" + code + " -> " + nom + " (" + prix + "�) (" + categorie.getLibelle() + ")";
		
		return Arrays.asList(this.getClass().getDeclaredFields())
				.stream()
				.filter(field -> field.getAnnotation(ToString.class) != null)
				.map(field -> {
					try {
						return field.getAnnotation(ToString.class).uppercase()
								? field.get(this).toString().toUpperCase() : field.get(this).toString();
					} catch (SecurityException | IllegalArgumentException | IllegalAccessException e1) {
						e1.printStackTrace();
						return "";
					}
				})
				.collect(Collectors.joining(" ")
		);
		
		/*
		Field[] variablesDeLaClasse = getClass().getDeclaredFields();
		String resultat = "";
		for (Field variableActuelle : variablesDeLaClasse) {
			
			// extraire l'annotation de classe ToString attach�e � la variable actuelle ;
			// obtient null si cette annotation n'est pas attach� � cette variable.
			ToString annotationActuelle = variableActuelle.getAnnotation(ToString.class);
			
			// annotation trouv�e : on peut afficher la valeur de cette variable 
			if (annotationActuelle != null) {
				try {
					
					String texteVariable;
					
					// la variable actuelle est une CategoriePizza : traitement sp�cifique
					if (variableActuelle.get(this) instanceof CategoriePizza) {
						texteVariable = ((CategoriePizza)variableActuelle.get(this)).getLibelle();
					} else {
						texteVariable = variableActuelle.get(this).toString();
					}
					
					
					// propri�t� de l'annotation : si "uppercase" est vrai, alors mettre en majuscule la valeur de la variable actuelle
					if (annotationActuelle.uppercase()) {
						//resultat += variableActuelle.get(this).toString().toUpperCase() + " ";
						resultat += texteVariable.toUpperCase() + " ";
						
					// sinon, aucune alt�ration
					} else {
						resultat += texteVariable + " ";
					}
					
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
			
		}
		return resultat;
		*/
		
	}
	
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

	public void setCategorie(CategoriePizza categorie) {
		this.categorie = categorie;
	}

	public CategoriePizza getCategorie() {
		return categorie;
	}

	public static int getNbPizzas() {
		return nbPizzas;
	}

	
}
