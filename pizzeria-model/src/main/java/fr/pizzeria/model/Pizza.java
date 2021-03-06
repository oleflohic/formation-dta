package fr.pizzeria.model;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Classe utilisée pour stocker les informations de pizza.
 * @author oleflohic
 */
@Entity
@Table(name="pizza")
public class Pizza {
	
	// ==== Classes ====
	/*
	public static class LongueurCodeException extends Exception {
		private static final long serialVersionUID = 1013815773107174810L;
		
		public LongueurCodeException(String string) {
			super(string);
		}
	}
	*/
	
	
	// ==== Constantes ====
	public static final int LONGUEUR_CODE = 3; 
	
	/**
	 * Nombre de (nouvelles) pizzas qui ont été créées depuis le début du programme.
	 */
	public static int nbPizzas;
	
	// ==== Variables ====
	
	/**
	 * Identifiant unique de la pizza. N'est pas forcément égal à l'index de valeur si stocké dans un tableau.
	 */
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	//@Column (name="id", unique=true)
	private Integer id;
	
	/**
	 * Code pizza en LONGUEUR_CODE caractères. Unique.
	 */
	@ToString
	@Column (name="code", length=LONGUEUR_CODE, unique=true)
	private String code;
	
	/**
	 * Nom affiché de la pizza.
	 */
	@ToString
	@Column (name="nom", length=50)
	private String nom;
	
	/**
	 * Prix de la pizza.
	 */
	@ToString
	@Column (name="prix", columnDefinition="DECIMAL(10,2)", nullable=false)
	private BigDecimal prix;
	
	/**
	 * Catégorie de la pizza.
	 */
	@ToString
	@Enumerated(EnumType.STRING)
	@Column (name="categorie", columnDefinition="ENUM('VIANDE', 'POISSON', 'SANS_VIANDE') DEFAULT 'SANS_VIANDE'", nullable=false)
	private CategoriePizza categorie = CategoriePizza.SANS_VIANDE;
	
	/**
	 * Url de l'image de la pizza.
	 */
	@Column (name="url_image", length=500, nullable=true)
	private String urlImage;
	
	
	// ==== Méthodes statiques ====
	/*
	public int genererNouvelId () {
		return ++nbPizzas;
	}
	*/
	
	// ==== Constructeurs ====
	
	public Pizza () {
		//this.id = nbPizzas;
		nbPizzas++;
	}
	
	/**
	 * Crée une nouvelle instance de pizza avec id unique.
	 * @param code
	 * @param nom 
	 * @param prix
	 * @param categorie
	 * @param urlImage
	 */
	public Pizza (String code, String nom, BigDecimal prix, CategoriePizza categorie, String urlImage) {
		this (nbPizzas, code, nom, prix, categorie);
		this.urlImage = urlImage;
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
	public Pizza (Integer id, String code, String nom, BigDecimal prix, CategoriePizza categorie) {
		//this.id = id;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.categorie = categorie;
	}
	
	
	
	// ==== Méthodes ====
	
	/**
	 * Cloner cette pizza.
	 */
	@Override
	public Pizza clone () {
		return new Pizza (id, code, nom, prix, categorie);
	}
	
	/**
	 * Informations de la pizza affichées
	 */
	@Override
	public String toString () {
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
	}
	
	

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17,37).append(code).toHashCode();
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
	}
	

	// ==== Accesseurs ====
	
	public void set (Pizza pizza) {
		//this.id = pizza.getId();
		this.code = new String(pizza.getCode());
		this.nom = new String(pizza.getNom());
		this.prix = pizza.getPrix();
		this.categorie = pizza.getCategorie();
		this.urlImage = new String(pizza.getUrlImage());
	} 
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code)/* throws LongueurCodeException*/ {
		/*
		if (code.length() != LONGUEUR_CODE) {
			throw new LongueurCodeException("Code '" + code + "' de longueur invalide : " + code.length() + " (attendu : " + LONGUEUR_CODE + ").");
		}
		*/
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public BigDecimal getPrix() {
		return prix;
	}

	public void setPrix(BigDecimal prix) {
		this.prix = prix;
	}
	
	public void setCategorie(CategoriePizza categorie) {
		this.categorie = categorie;
	}
	
	public CategoriePizza getCategorie() {
		return categorie;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	public static int getNbPizzas() {
		return nbPizzas;
	}

	
}
