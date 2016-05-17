package fr.pizzeria.model;

/**
 * Utilisé pour définir les catégories de pizza.
 * @author oleflohic
 */
public enum CategoriePizza {
	
	
	// ==== Valeurs d'énumération ====
	
	VIANDE("Viande"), POISSON("Poisson"), SANS_VIANDE("Sans viande");
	
	
	// ==== Variables ====
	
	private String libelle;
	
	
	// ==== Constructeurs ====

	private CategoriePizza(String libelle) {
		this.libelle = libelle;
	}
	
	
	// ==== Méthodes ====
	
	@Override
	public String toString () {
		return name() + " -> " + libelle;
	}
	
	
	// ==== Accesseurs ====
	
	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	

}
