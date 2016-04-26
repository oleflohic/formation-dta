package fr.operateurs.console;

import java.util.Scanner;

/**
 * @author oleflohic
 * Classe exécutable. Permet de faire des opérations en mode lignes de commande. 
 */
public class OperateursApp {

	/**
	 * Classe principale.
	 * @param args Arguments du programme.
	 */
	public static void main(String[] args) {
		
		// initialisations
		
		Scanner sc = new Scanner(System.in);
		double nb1, nb2, res;
		
		
		// opérations
		
		System.out.println("Saisir le premier nombre : ");
		nb1 = sc.nextDouble();
		System.out.println("Saisir le second nombre : ");
		nb2 = sc.nextDouble();
		
		res = nb1 + nb2;
		System.out.println("ADDITION => " + nb1 + " + " + nb2 + " = " + res);
		
		res = nb1 - nb2;
		System.out.println("SOUSTRACTION => " + nb1 + " - " + nb2 + " = " + res);

		res = nb1 * nb2;
		System.out.println("MULTIPLICATION => " + nb1 + " * " + nb2 + " = " + res);

		res = nb1 / nb2;
		System.out.println("DIVISION => " + nb1 + " / " + nb2 + " = " + res);

		res = nb1 % nb2;
		System.out.println("MODULO => " + nb1 + " % " + nb2 + " = " + res);

		
		// dernières initialisations afin la fin du programme
		
		sc.close();
		
	}

}
