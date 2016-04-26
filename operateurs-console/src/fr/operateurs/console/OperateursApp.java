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
		
		System.out.println("ADDITION - Saisir deux nombres : ");
		nb1 = sc.nextDouble();
		nb2 = sc.nextDouble();
		res = nb1 + nb2;
		System.out.println("" + nb1 + " + " + nb2 + " = " + res);

		System.out.println("SOUSTRACTION - Saisir deux nombres : ");
		nb1 = sc.nextDouble();
		nb2 = sc.nextDouble();
		res = nb1 - nb2;
		System.out.println("" + nb1 + " - " + nb2 + " = " + res);

		System.out.println("MULTIPLICATION - Saisir deux nombres : ");
		nb1 = sc.nextDouble();
		nb2 = sc.nextDouble();
		res = nb1 * nb2;
		System.out.println("" + nb1 + " * " + nb2 + " = " + res);

		System.out.println("DIVISION - Saisir deux nombres : ");
		nb1 = sc.nextDouble();
		nb2 = sc.nextDouble();
		res = nb1 / nb2;
		System.out.println("" + nb1 + " / " + nb2 + " = " + res);

		System.out.println("MODULO - Saisir deux nombres : ");
		nb1 = sc.nextDouble();
		nb2 = sc.nextDouble();
		res = nb1 % nb2;
		System.out.println("" + nb1 + " % " + nb2 + " = " + res);
		
		
		// dernières initialisations afin la fin du programme
		
		sc.close();
		
	}

}
