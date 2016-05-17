package fr.pizzeria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="livreur")
public class Livreur {
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column (name="nom", length=50)
	private String nom;
	
	@Column (name="prenom", length=50)
	private String prenom;
	
	

	/*
	@OneToMany
	private Set<Commande> commandes;
	*/
	
	
	
	
	
	
	

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
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
	
	/*
	public Set<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(Set<Commande> commandes) {
		this.commandes = commandes;
	}
	*/
	
}
