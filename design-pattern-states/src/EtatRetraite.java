
public class EtatRetraite extends EtatViePersonne {

	@Override
	public void ajoutePoints(int points) {
		// pas de points rajout�s : d�j� en retraite
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
