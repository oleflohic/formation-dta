
public class EtatRetraite extends EtatViePersonne {

	@Override
	public void ajoutePoints(int points) {
		// pas de points rajoutés : déjà en retraite
	}

	@Override
	public String getNom() {
		return "retraite";
	}

	@Override
	public EtatViePersonne getNext() {
		return null;
	}

}
