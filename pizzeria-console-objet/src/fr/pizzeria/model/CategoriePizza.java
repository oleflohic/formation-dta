package fr.pizzeria.model;

/**
 * Utilis� pour d�finir les cat�gories de pizza.
 * @author oleflohic
 */
public enum CategoriePizza {
	
	
	// ==== Valeurs d'�num�ration ====
	
	VIANDE("Viande"), POISSON("Poisson"), SANS_VIANDE("Sans viande");
	
	
	// ==== Variables ====
	
	private String libelle;
	
	
	// ==== Constructeurs ====

	private CategoriePizza(String libelle) {
		this.libelle = libelle;
	}
	
	
	// ==== M�thodes ====
	
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
