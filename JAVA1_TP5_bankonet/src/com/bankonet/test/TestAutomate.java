package com.bankonet.test;

import com.bankonet.ICompteStat;

public class TestAutomate {

	public static void main(String[] args) {
		
		ICompteStat[] comptes = DonneesTest.construitEchantillonComptes();
		
		float somme = 0f;
		
		for (ICompteStat c : comptes) {
			somme += c.getSolde();
		}
		
		// rq : on part du principe qu'il y a au moins un compte
		System.out.println("Moyenne : " + somme / comptes.length);
		
	}

}
