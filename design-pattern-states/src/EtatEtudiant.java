
public class EtatEtudiant extends EtatViePersonne {

	@Override
	public void ajoutePoints(int points) {
		// pas de points pour les �tudiants
	}

	@Override
	public String getNom() {
		return "Etudiant";
	}

	@Override
	public EtatViePersonne getNext() {
		EtatViePersonne suivant = new EtatVieActive ();
		suivant.setPersonne(personne);
		return suivant;
	}

}
