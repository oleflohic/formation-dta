package fr.pizzeria.console;

import java.util.Scanner;

/**
 * @author oleflohic
 * Classe ex�cutable.
 */
public class PizzeriaAdminConsoleApp {
	/**
	 * Classe principale.
	 * @param args Arguments du programme.
	 */
	public static void main(String[] args) {
		
		// initialisations
		
		Scanner sc = new Scanner(System.in);
		int choix;
		
		// pizzas existantes
		Object[][] pizzas = new Object[][] {
				new Object[] {"PEP", "Peperoni", 10f},
				new Object[] {"MAR", "Margherita", 14f},
				new Object[] {"REI", "La Reine", 11.5f},
				new Object[] {"FRO", "La 4 fromages", 12f},
				new Object[] {"CAN", "La cannibale", 12.5f},
				new Object[] {"SAV", "La savoyarde", 13f},
				new Object[] {"ORI", "L'orientale", 13.5f},
				new Object[] {"IND", "L'indienne", 14f},
		};
		
		// menu principal et lecture du choix
		
		System.out.println (
			"***** Pizzeria Administration *****\n"
			+ " 1. Lister les pizzas\n"
			+ " 2. Ajouter une nouvelle pizza\n"
			+ " 3. Mettre � jour une pizza\n"
			+ " 4. Supprimer une pizza\n"
			+ "99. Sortir"
		);
		
		System.out.print("Choix : ");
		choix = sc.nextInt();
		
		// poursuivre jusqu'� ce que l'utilisateur demande de sortir
		while (choix != 99) {
			
			boolean codePris;
			
			// tester le choix et agir en cons�quences 
			
			switch (choix) {
			
			case 1: // lister les pizzas
				System.out.println();
				System.out.println("Liste des pizzas :");
				
				// aucune pizza : message d'information
				if (pizzas.length == 0) {
					System.out.println("Il n'y a aucune pizza dans la base.");
				} else {
					for (int i = 0 ; i < pizzas.length ; i++) {
						System.out.println("" + pizzas[i][0] + " -> " + pizzas[i][1] + " (" + pizzas[i][2] + "�)");
					}
				}
				
				break;
			
			case 2: // ajouter une nouvelle pizza
				System.out.print("Veuillez saisir le code : ");
				String codeNouveau = sc.next();
				
				System.out.print("Veuillez saisir le nom : ");
				String nomNouveau = sc.next();
				
				System.out.print("Veuillez saisir le prix (utiliser , comme s�parateur d�cimal) : ");
				float prixNouveau = sc.nextFloat();
				
				// tester si le code est pris
				codePris = false;
				for (int i = 0 ; i < pizzas.length ; i++) {
					if (pizzas[i][0].equals(codeNouveau)) {
						System.out.println("Erreur : le code " + codeNouveau + " est d�j� pris.");
						codePris = true;
						break;
					}
				}
				
				// s'il n'est pas pris, ajouter la pizza
				if (!codePris) {
					Object[] nouvellePizza = new Object[] { codeNouveau, nomNouveau, prixNouveau };
					Object[][] nouvelleListePizzas = new Object[pizzas.length+1][];
					// copier le contenu de la vieille liste dans la nouvelle,
					// puis mettre la nouvelle pizza � sa fin
					for (int i = 0 ; i < pizzas.length ; i++) {
						nouvelleListePizzas[i] = pizzas[i];
					}
					nouvelleListePizzas[pizzas.length] = nouvellePizza;
					pizzas = nouvelleListePizzas;
				}
				
				break;
				
			case 3: // mettre � jour une pizza
				

				// aucune pizza : message d'information et sortie imm�diate
				if (pizzas.length == 0) {
					System.out.println("Il n'y a aucune pizza dans la base ; pas de mise-�-jour possible.");
				} else {
				
					// afficher la liste
					for (int i = 0 ; i < pizzas.length ; i++) {
						System.out.println(
								"" + pizzas[i][0] + " -> " + pizzas[i][1] + " (" + pizzas[i][2] + "�)"
							);
					}
					
					// demander de s�lectionner une pizza et lire la saisie clavier
					System.out.println("Veuillez choisir la pizza � modifier.\n(99 pour abandonner).");
					System.out.println("Code de la pizza � modifier : ");
					String codeSelectionneMaj = sc.next();
					
					// l'utilisateur abandonne la modification
					if (codeSelectionneMaj.equals("99")) {
						System.out.println("Abandon de la mise-�-jour.");
						
					// sinon continuer les saisies
					} else {
	
						// chercher l'index de la pizza � m�j
						int indexPizzaMaj = -1;
						for (int i = 0 ; i < pizzas.length ; i++) {
							if (pizzas[i][0].equals(codeSelectionneMaj)) {
								indexPizzaMaj = i;
								break;
							}
						}
						
						// cas d'erreur : code introuvable
						if (indexPizzaMaj == -1) {
							System.out.println("Erreur : le code " + codeSelectionneMaj + " est introuvable.");
						} else {
							
							// m�j des infos
							System.out.print("Veuillez saisir le nouveau code : ");
							String codeMaj = sc.next();
							
							System.out.print("Veuillez saisir le nouveau nom : ");
							String nomMaj = sc.next();
							
							System.out.print("Veuillez saisir le nouveau prix (utiliser , comme s�parateur d�cimal) : ");
							float prixMaj = sc.nextFloat();
							
							// cas d'erreur : code d�j� pris
							codePris = false;
							if (!codeSelectionneMaj.equals(codeMaj)) {
								for (int i = 0 ; i < pizzas.length ; i++) {
									if (pizzas[i][0].equals(codeMaj)) {
										System.out.println("Erreur : le code " + codeMaj + " est d�j� pris.");
										codePris = true;
									}
								}
							}
							
							// succ�s : m�j de la pizza
							if (!codePris) {
								pizzas[indexPizzaMaj] = new Object[] { codeMaj, nomMaj, prixMaj };
							}
							
						}
					}
				}
				
				break;
				
				
			case 4: // supprimer une pizza

				// aucune pizza : message d'information et sortie imm�diate
				if (pizzas.length == 0) {
					System.out.println("Il n'y a aucune pizza dans la base ; pas de suppression possible.");
				} else {
				
					// afficher la liste
					for (int i = 0 ; i < pizzas.length ; i++) {
						System.out.println(
								"" + pizzas[i][0] + " -> " + pizzas[i][1] + " (" + pizzas[i][2] + "�)"
							);
					}
					
					// demander de s�lectionner une pizza et lire la saisie clavier
					System.out.println("Veuillez choisir la pizza � supprimer.\n(99 pour abandonner).");
					System.out.println("Code de la pizza � supprimer : ");
					String codeSelectionneSuppr = sc.next();
					
					
	
					// l'utilisateur abandonne la modification
					if (codeSelectionneSuppr.equals("99")) {
						System.out.println("Abandon de la suppression.");
						
					// sinon continuer les saisies
					} else {
	
						
						// chercher l'index de la pizza � supprimer
						int indexPizzaSuppr = -1;
						for (int i = 0 ; i < pizzas.length ; i++) {
							if (pizzas[i][0].equals(codeSelectionneSuppr)) {
								indexPizzaSuppr = i;
								break;
							}
						}
						
						// cas d'erreur : code introuvable
						if (indexPizzaSuppr == -1) {
							System.out.println("Erreur : le code " + codeSelectionneSuppr + " est introuvable.");
						} else {
		
							Object[][] pizzasApresSuppression = new Object[pizzas.length-1][];
							
							// cr�er un nouveau tableau qui ne contient pas l'�l�ment supprim�
							if (indexPizzaSuppr == 0) { // cas d�but de liste
								
								for (int i = 1 ; i < pizzas.length ; i++) {
									pizzasApresSuppression[i-1] = pizzas[i];
								}
								
							} else if (indexPizzaSuppr == (pizzas.length - 1)) { // cas fin de liste
		
								for (int i = 0 ; i < pizzas.length-1 ; i++) {
									pizzasApresSuppression[i] = pizzas[i];
								}
								
							} else { // cas milieu de liste
								
								// avant l'index de la pizza supprim�e
								for (int i = 0 ; i < indexPizzaSuppr ; i++) {
									pizzasApresSuppression[i] = pizzas[i];
								}
								
								// apr�s l'index
								for (int i = indexPizzaSuppr+1 ; i < pizzas.length ; i++) {
									pizzasApresSuppression[i-1] = pizzas[i];
								}
								
							}
							
							// remplacement de la liste
							pizzas = pizzasApresSuppression;
						
						}
					}
				}
				
				break;
			}
			
			// menu principal et lecture du choix
			System.out.println();
			System.out.println (
				"***** Pizzeria Administration *****\n"
				+ " 1. Lister les pizzas\n"
				+ " 2. Ajouter une nouvelle pizza\n"
				+ " 3. Mettre � jour une pizza\n"
				+ " 4. Supprimer une pizza\n"
				+ "99. Sortir"
			);
			
			System.out.print("Choix : ");
			choix = sc.nextInt();
			
		}
		
		
		// fin
		
		System.out.println("Au revoir.");
		
		
		
		// derni�res initialisations afin la fin du programme
		
		sc.close();

	}

}
