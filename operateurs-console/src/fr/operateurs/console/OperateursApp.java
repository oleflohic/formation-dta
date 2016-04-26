package fr.operateurs.console;

import java.util.Scanner;

/**
 * @author oleflohic
 * Classe ex�cutable. Permet de faire des op�rations en mode lignes de commande. 
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
		
		// op�rations
		
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
		
		
		// derni�res initialisations afin la fin du programme
		
		sc.close();
		
	}

}
