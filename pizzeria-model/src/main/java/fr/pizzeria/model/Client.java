package fr.pizzeria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="client")
public class Client {
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column (name="nom", length=50)
	private String nom;
	
	@Column (name="prenom", length=50)
	private String prenom;


	@Column (name="email", length=300)
	private String email;
	
	@Column (name="mot_de_passe", length=50)
	private String motDePasse;

	/*
	@OneToMany
	private Set<Commande> commandes;
	*/
	
	// client(id,nom,prenom,email,mot_de_passe)
	/*
	public Client () {
		id = new Integer(0);
		nom = new String();
		prenom = new String();
		email = new String();
		motDePasse = new String();
	}
	*/
	
	
	
	
	
	
	
	
	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	
	/*
	public Set<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(Set<Commande> commandes) {
		this.commandes = commandes;
	}
	*/
	
	
	
	
	
	
}
