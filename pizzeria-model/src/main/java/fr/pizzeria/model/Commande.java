package fr.pizzeria.model;

import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="commande")
public class Commande {
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="numero_commande", unique=true)
	private Integer numeroCommande;
	
	@Column(name="status", length=50)
	private String status;

	@Column(name="date_commande")
	private Time dateCommande;
	
	@ManyToOne
	@JoinColumn(name="livreur_id")
	private Livreur livreur;
	
	@ManyToOne
	@JoinColumn(name="client_id")
	private Client client;
	
	@ManyToMany
	@JoinTable(name="commande_pizza",
		joinColumns=
			@JoinColumn(name="id_commande", referencedColumnName="id"),
		inverseJoinColumns=
			@JoinColumn(name="id_pizza", referencedColumnName="id")
	)
	private Set<Pizza> pizzas;
	
	
	public Commande () {
		id = 0;
		numeroCommande = 0;
		status = new String();
		livreur = null;
		client = null;
		pizzas = new HashSet<Pizza>();
	}
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumeroCommande() {
		return numeroCommande;
	}

	public void setNumeroCommande(Integer numeroCommande) {
		this.numeroCommande = numeroCommande;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Time getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Time dateCommande) {
		this.dateCommande = dateCommande;
	}

	public Livreur getLivreur() {
		return livreur;
	}

	public void setLivreur(Livreur livreur) {
		this.livreur = livreur;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public Set<Pizza> getPizzas () {
		return pizzas;
	}
	
	public void setPizzas (Set<Pizza> pizzas) {
		this.pizzas = pizzas;
	}
	
	
	
}
