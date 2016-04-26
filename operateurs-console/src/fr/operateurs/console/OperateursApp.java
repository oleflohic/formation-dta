package fr.operateurs.console;

import java.util.Scanner;

/**
 * @author oleflohic
 *
 */
public class OperateursApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Saisir un nombre: ");
		double nb = sc.nextDouble();
		System.out.println("Nombre saisi : " + nb);
		
		sc.close();
		
	}

}
