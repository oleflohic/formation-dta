
public abstract class EtatViePersonne {
	
	protected Personne personne;
	
	public abstract void ajoutePoints (int points);
	public abstract String getNom ();
	
	public abstract EtatViePersonne getNext();
	
	public void setPersonne (Personne personne) {
		this.personne = personne;
	}
	public Personne getPersonne () {
		return personne;
	}
	
	

}
