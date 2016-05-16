package fr.pizzeria.model;

import java.util.Arrays;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Classe utilisée pour stocker les informations de pizza.
 * @author oleflohic
 */
@Entity
public class Pizza {
	
	/**
	 * Nombre de (nouvelles) pizzas qui ont été créées depuis le début du programme.
	 */
	public static int nbPizzas;
	
	// ==== Variables ====
	
	/**
	 * Identifiant unique de la pizza. N'est pas forcément égal à l'index de valeur si stocké dans un tableau.
	 */
	@Id
	@GeneratedValue
	private int id;
	
	/**
	 * Code pizza en 3 caractères. Unique.
	 */
	@ToString
	@Column (name="CODE", length=3, unique=true)
	private String code;
	
	/**
	 * Nom affiché de la pizza.
	 */
	@ToString
	@Column (name="LIBELLE", length=50)
	private String nom;
	
	/**
	 * Prix de la pizza.
	 */
	@ToString
	@Column (name="PRIX")
	private double prix;
	
	/**
	 * Catégorie de la pizza.
	 */
	@ToString
	@Enumerated
	@Column (name="CATEGORIE")
	private CategoriePizza categorie;
	
	
	// ==== Constructeurs ====

	public Pizza () {
		this.id = nbPizzas;
		nbPizzas++;
	}
	/**
	 * Crée une nouvelle instance de pizza avec id unique.
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
	 * Crée une instance de pizza dont l'id a été précisé. N'incrémente pas nbPizzas.
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
	
	// ==== Méthodes ====
	
	/**
	 * Cloner cette pizza.
	 */
	public Pizza clone () {
		return new Pizza (id, code, nom, prix, categorie);
		
	}
	
	/**
	 * Informations de la pizza affichées
	 */
	@Override
	public String toString () {
		
		//return "" + code + " -> " + nom + " (" + prix + "€) (" + categorie.getLibelle() + ")";
		
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
			
			// extraire l'annotation de classe ToString attachée à la variable actuelle ;
			// obtient null si cette annotation n'est pas attaché à cette variable.
			ToString annotationActuelle = variableActuelle.getAnnotation(ToString.class);
			
			// annotation trouvée : on peut afficher la valeur de cette variable 
			if (annotationActuelle != null) {
				try {
					
					String texteVariable;
					
					// la variable actuelle est une CategoriePizza : traitement spécifique
					if (variableActuelle.get(this) instanceof CategoriePizza) {
						texteVariable = ((CategoriePizza)variableActuelle.get(this)).getLibelle();
					} else {
						texteVariable = variableActuelle.get(this).toString();
					}
					
					
					// propriété de l'annotation : si "uppercase" est vrai, alors mettre en majuscule la valeur de la variable actuelle
					if (annotationActuelle.uppercase()) {
						//resultat += variableActuelle.get(this).toString().toUpperCase() + " ";
						resultat += texteVariable.toUpperCase() + " ";
						
					// sinon, aucune altération
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
	
	

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17,37).append(code).toHashCode();
		
		/*
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categorie == null) ? 0 : categorie.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + id;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		long temp;
		temp = Double.doubleToLongBits(prix);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
		*/
	}
	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		Pizza other = (Pizza) obj;
		
		return new EqualsBuilder()
				.append(categorie, other.categorie)
				.append(code,  other.code)
				.append(id,  other.id)
				.append(nom, other.nom)
				.append(prix, other.prix)
				.build();
		/*
		if (categorie != other.categorie)
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (id != other.id)
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (Double.doubleToLongBits(prix) != Double.doubleToLongBits(other.prix))
			return false;
		return true;
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
