package com.bankonet.model;

import com.bankonet.CreditException;
import com.bankonet.DebitException;
import com.bankonet.ICompteStat;

/**
 * @author fguibert
 */
public abstract class Compte implements ICompteStat {
	private String libelle;
	private int identifiant;
	protected float solde;

	Compte() { }
	Compte(int id, String libelle, float solde) {
		this.identifiant = id;
		this.libelle = libelle;
		this.solde = solde;
	}
	
	public String toString() {
	        return  " ID  : "+this.getIdentifiant() +" - "+
		    		" Lib : "+this.getLibelle()+" - "+
		    		" Solde : "+this.getSolde()+"€";
	}

	public void crediter(float montant) throws CreditException {
		this.setSolde( this.getSolde() + montant);
	}
	
	public void debiter(float montant) throws DebitException {
		if (montant > this.getSolde()) {
			throw new DebitException("Montant du débit (" + montant + ") supérieur au solde (" + getSolde() + ").");
		}
		this.setSolde( this.getSolde() - montant);
	}
	
	public void effectuerVirement (Compte compte, float montant)
			throws DebitException, CreditException {
		
		debiter(montant);
		try {
			compte.crediter(montant);
		} catch (CreditException e) {
			// rendre le montant si l'opération de crédit a échoué
			crediter(montant);
			// propager l'erreur de nouveau
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public abstract boolean creditAutorise(float montant) throws BankonetException;

	public abstract boolean debitAutorise(float montant) throws BankonetException;

	
	
	
	
	public String getLibelle() {
		return libelle;
	}

	public int getIdentifiant() {
		return identifiant;
	}

	public float getSolde() {
		return solde;
	}

	private void setSolde(float newSolde) {
		this.solde = newSolde;
	}
}
