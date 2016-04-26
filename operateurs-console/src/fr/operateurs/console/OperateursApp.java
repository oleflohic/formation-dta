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
		String typeOperation;
		
		// opérations
		
		typeOperation = "ADDITION";
		System.out.println(typeOperation + " - Saisir le premier nombre : ");
		nb1 = sc.nextDouble();
		System.out.println(typeOperation + " - Saisir le second nombre : ");
		nb2 = sc.nextDouble();
		res = nb1 + nb2;
		System.out.println("" + nb1 + " + " + nb2 + " = " + res);

		typeOperation = "SOUSTRACTION";
		System.out.println(typeOperation + " - Saisir le premier nombre : ");
		nb1 = sc.nextDouble();
		System.out.println(typeOperation + " - Saisir le second nombre : ");
		nb2 = sc.nextDouble();
		res = nb1 - nb2;
		System.out.println("" + nb1 + " - " + nb2 + " = " + res);

		typeOperation = "MULTIPLICATION";
		System.out.println(typeOperation + " - Saisir le premier nombre : ");
		nb1 = sc.nextDouble();
		System.out.println(typeOperation + " - Saisir le second nombre : ");
		nb2 = sc.nextDouble();
		res = nb1 * nb2;
		System.out.println("" + nb1 + " * " + nb2 + " = " + res);

		typeOperation = "DIVISION";
		System.out.println(typeOperation + " - Saisir le premier nombre : ");
		nb1 = sc.nextDouble();
		System.out.println(typeOperation + " - Saisir le second nombre : ");
		nb2 = sc.nextDouble();
		res = nb1 / nb2;
		System.out.println("" + nb1 + " / " + nb2 + " = " + res);

		typeOperation = "MODULO";
		System.out.println(typeOperation + " - Saisir le premier nombre : ");
		nb1 = sc.nextDouble();
		System.out.println(typeOperation + " - Saisir le second nombre : ");
		nb2 = sc.nextDouble();
		res = nb1 % nb2;
		System.out.println("" + nb1 + " % " + nb2 + " = " + res);
		
		
		// dernières initialisations afin la fin du programme
		
		sc.close();
		
	}

}
