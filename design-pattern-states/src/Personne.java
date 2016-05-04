
public class Personne {

	protected String nom;

	protected EtatViePersonne etat;
	protected int pointsRetraite = 0;
	
	public void etatSuivant () {
		etat = etat.getNext();
	}
	
	
	
	
	
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getPointsRetraite () {
		return pointsRetraite;
	}

	public void setPointsRetraite (int pointsRetraite) {
		this.pointsRetraite = pointsRetraite;
	}
	
	public void setEtat (EtatViePersonne etat) {
		this.etat = etat;
	}
	public EtatViePersonne getEtat () {
		return etat;
	}
	
}
