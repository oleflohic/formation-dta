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
	
	
	// ==== Accesseurs ====
	
	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	/*
	public static CategoriePizza convertirChaine(String categoriePizza) throws CategoriePizzaException {
		
		switch (categoriePizza) {
		case "VIANDE":
			return VIANDE;
		case "SANS_VIANDE":
			return SANS_VIANDE;
		case "POISSON":
			return POISSON;
		default:
			throw new CategoriePizzaException("Catégorie de pizza \"" + categoriePizza + "\" inconnue.");
		}
		
	}
	*/
	
	
	
	
	

}
