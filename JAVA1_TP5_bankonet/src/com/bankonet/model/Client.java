package com.bankonet.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Modelise un client de bankonet.
 *
 * <p>Un client est caracterise par :
 * <ul>
 * <li> son identifiant unique
 * <li> son nom
 * <li> son prenom
 * <li> la liste de ses comptes
 * </ul>
 *
 * @author fguibert
 */
public class Client implements Comparable {
	private int identifiant;
	private String nom;
	private String prenom;
	
	private List<?> compteCourantList;
	private List<?> compteEpargneList;
	
	private List<Compte> comptes;
	
	/**
	 * @param nom
	 * @param prenom
	 * @param identifiant
	 */
	public Client(int identifiant, String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.identifiant = identifiant;
		this.comptes = new ArrayList<Compte>();
	}
	
	
	public Client(int identifiant, String nom, String prenom, List<?> ccList, List<?> ceList) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.identifiant = identifiant;
		
		this.compteCourantList = ccList;
		this.compteEpargneList = ceList;
	}
	
	
	
	public String toString() {
		 return " ID  : "+this.getIdentifiant() +" - "+
		    	" Nom : "+this.getNom()+" - "+
		    	" Prénom : "+this.getPrenom();
		
	}
	
	public void creerCompte(Compte compte) {
		comptes.add(compte);
	}
	
	public void supprimerCompte(Compte compte) {
		comptes.remove(compte);
	}
	
	public Compte retournerCompte(int id) {
		Iterator<Compte> it = comptes.iterator();
		while (it.hasNext()) {
			Compte compteItere = it.next();
			if (compteItere.getIdentifiant() == id) {
				return compteItere;
			}
		}
		return null;
	}
	
	public void supprimerCompte(int id) {
		Iterator<Compte> it = comptes.iterator();
		while (it.hasNext()) {
			Compte compteItere = it.next();
			if (compteItere.getIdentifiant() == id) {
				supprimerCompte(compteItere);
				break;
			}
		}
	}
	
	public float calculerAvoirGLobal() {
		
		List<Compte> tousLesComptes = this.getComptes(); //new ArrayList(this.getComptes());
		
		
		float soldeTotal = 0;
		for(Compte myC : tousLesComptes) {
			soldeTotal += myC.getSolde();
		}
		return soldeTotal;
		
	}
	/**
	 * @param compteCourantList The compteCourantList to set.
	 */
	/*
	public void setCompteCourantList(List<?> compteCourantList) {
		this.compteCourantList = compteCourantList;
	}
	*/
	/**
	 * @param compteEpargneList The compteEpargneList to set.
	 */
	/*
	public void setCompteEpargneList(List<?> compteEpargneList) {
		this.compteEpargneList = compteEpargneList;
	}
	*/
	





	/**
	 * Retourne la liste des comptes courants du client (de taille 0 si pas de comptes courants).
	 * 
	 *
	 * @return List
	 */
	public List<?> getComptesCourants() {
		return Collections.unmodifiableList(compteCourantList);
	}

	/**
	 * Retourne la liste des comptes d'epargne du client sous forme d'une ArrayList (de taille 0 si pas de compte epargne).
	 * 
	 * @return List
	 */
	public List<?> getComptesEpargne() {
		return Collections.unmodifiableList(compteEpargneList);
	}
	
	public List<Compte> getComptes() {
	    /*
	    ArrayList<Object> compteList = new ArrayList<>();
	    compteList.addAll(compteCourantList);
	    compteList.addAll(compteEpargneList);
	    return Collections.unmodifiableList(compteList);
	    */
	    return Collections.unmodifiableList(comptes);

	}

	public Compte getCompte(int compteId) {
	    List<Compte> compteList = this.getComptes();
	    Iterator<Compte> compteIte = compteList.iterator();
	    while (compteIte.hasNext()) {
            Compte compte = compteIte.next();
            if (compteId == compte.getIdentifiant())
                return compte;
        }
	    return null; 
	}
	
	public int getIdentifiant() {
		return identifiant;
	}
	/**
	 * Retourne le nom du client.
	 *
	 * @return java.lang.String
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * Retourne le prenom du client.
	 * 
	 * @return java.lang.String
	 */
	public String getPrenom() {
		return prenom;
	}


	@Override
	public int compareTo(Object o) throws ClassCastException {
		if (!(o instanceof Client)) {
			throw new ClassCastException("Object Client attendu");
		}
		// TODO
		//Integer anotherId = ((Client)o).
		return 0;
	}
}
