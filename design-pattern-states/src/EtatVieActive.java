
public class EtatVieActive extends EtatViePersonne {

	@Override
	public void ajoutePoints(int points) {
		personne.setPointsRetraite(personne.getPointsRetraite() + points);
	}

	@Override
	public String getNom() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EtatViePersonne getNext() {
		EtatViePersonne suivant = new EtatRetraite ();
		suivant.setPersonne(personne);
		return suivant;
	}

}
