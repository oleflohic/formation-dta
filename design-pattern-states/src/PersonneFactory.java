
public class PersonneFactory {
	
	public PersonneFactory () {
	}
	
	public Personne creerPersonne (String nom) {
		
		Personne personne = new Personne ();
		EtatViePersonne etat = new EtatEtudiant ();
		
		personne.setNom(nom);
		personne.setEtat(etat);
		
		etat.setPersonne(personne);
		
		return personne;
		
	}
	
}
