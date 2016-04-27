package fr.pizzeria.console;

import java.util.Scanner;
import fr.pizzeria.model.Pizza;

/**
 * @author oleflohic
 */
public class PizzeriaAdminConsoleApp {
	
	// VARIABLES STATIQUES
	
	// lecteur d'entrées clavier
	protected static Scanner sc;

	// pizzas existantes
	protected static Pizza[] pizzas = new Pizza[] {
			new Pizza ("PEP", "Peperoni", 10),
			new Pizza ("MAR", "Margherita", 14),
			new Pizza ("REI", "La Reine", 11.5),
			new Pizza ("FRO", "La 4 fromages", 12),
			new Pizza ("CAN", "La cannibale", 12.5),
			new Pizza ("SAV", "La savoyarde", 13),
			new Pizza ("ORI", "L'orientale", 13.5),
			new Pizza ("IND", "L'indienne", 14),
		};
	
	
	// METHODES STATIQUES
	
	/**
	 * afficher le menu principale ET demander à l'utilisateur de choisir une valeur.
	 * @return l'entier saisi par l'utilisateur, qui correspond à l'action choisie.
	 */
	public static int menuPrincipal () {

		// menu principal et lecture du choix
		
		System.out.println (
			"***** Pizzeria Administration *****\n"
			+ " 1. Lister les pizzas\n"
			+ " 2. Ajouter une nouvelle pizza\n"
			+ " 3. Mettre à jour une pizza\n"
			+ " 4. Supprimer une pizza\n"
			+ "99. Sortir"
		);
		
		System.out.print("Choix : ");
		return sc.nextInt();
		
	}
	
	/**
	 * afficher les pizzas existantes
	 */
	public static void listerPizzas () {
		
		System.out.println();
		System.out.println("Liste des pizzas :");
		
		// aucune pizza : message d'information
		if (pizzas.length == 0) {
			System.out.println("Il n'y a aucune pizza dans la base.");
		} else {
			
			for (int i = 0 ; i < pizzas.length ; i++) {
				System.out.println("" + pizzas[i].code + " -> " + pizzas[i].nom + " (" + pizzas[i].prix + "€)");
			}
			
			// afficher le nombre de pizzas crées depuis le début. grammaire en bonus.
			if (Pizza.nbPizzas > 1) {
				System.out.println("------- " + Pizza.nbPizzas + " pizzas créées depuis l’initialisation du programme");
			} else {
				System.out.println("------- " + Pizza.nbPizzas + " pizza créée depuis l’initialisation du programme");
			}
		}
		
	}
	
	public static void ajouterPizza () {

		System.out.print("Veuillez saisir le code : ");
		String codePizzaAjoutee = sc.next();

		// tester si le code est pris
		boolean codePris = false;
		for (int i = 0 ; i < pizzas.length ; i++) {
			if (pizzas[i].code.equals(codePizzaAjoutee)) {
				System.out.println("Erreur : le code " + codePizzaAjoutee + " est déjà pris.");
				codePris = true;
				break;
			}
		}
		
		
		// s'il n'est pas pris, saisir les informations supplémentaires et ajouter la pizza
		if (!codePris) {
			
			System.out.print("Veuillez saisir le nom : ");
			String nomPizzaAjoutee = sc.next();
			
			System.out.print("Veuillez saisir le prix (utiliser , comme séparateur décimal) : ");
			float prixPizzaAjoutee = sc.nextFloat();
			
			Pizza pizzaAjoutee = new Pizza (codePizzaAjoutee, nomPizzaAjoutee, prixPizzaAjoutee);
			Pizza[] pizzasApresAjout = new Pizza[pizzas.length+1];
			// copier le contenu de la vieille liste dans la nouvelle,
			// puis mettre la nouvelle pizza à sa fin
			for (int i = 0 ; i < pizzas.length ; i++) {
				pizzasApresAjout[i] = pizzas[i];
			}
			pizzasApresAjout[pizzas.length] = pizzaAjoutee;
			pizzas = pizzasApresAjout;
		}
		
	}

	/**
	 * mettre-à-jour (màj) une pizza en demandant à l'utilisateur de saisir les informations requises
	 */
	public static void majPizza () {

		// aucune pizza : message d'information et sortie immédiate
		if (pizzas.length == 0) {
			System.out.println("Il n'y a aucune pizza dans la base ; pas de mise-à-jour possible.");
		} else {
		
			// afficher la liste
			listerPizzas ();
			
			// demander de sélectionner une pizza et lire la saisie clavier
			System.out.println("Veuillez choisir la pizza à modifier.\n(99 pour abandonner).");
			System.out.println("Code de la pizza à modifier : ");
			String codePizzaAMaj = sc.next();
			
			// l'utilisateur abandonne la modification
			if (codePizzaAMaj.equals("99")) {
				System.out.println("Abandon de la mise-à-jour.");
				
			// sinon continuer les saisies
			} else {

				// chercher l'index de la pizza à màj
				int indexPizzaAMaj = -1;
				for (int i = 0 ; i < pizzas.length ; i++) {
					if (pizzas[i].code.equals(codePizzaAMaj)) {
						indexPizzaAMaj = i;
						break;
					}
				}
				
				// cas d'erreur : code introuvable
				if (indexPizzaAMaj == -1) {
					System.out.println("Erreur : le code " + codePizzaAMaj + " est introuvable.");
				} else {
					
					// màj des infos
					System.out.print("Veuillez saisir le nouveau code : ");
					String codePizzaApresMaj = sc.next();
					

					// cas d'erreur : code déjà pris
					boolean codePris = false;
					if (!codePizzaAMaj.equals(codePizzaApresMaj)) {
						for (int i = 0 ; i < pizzas.length ; i++) {
							if (pizzas[i].code.equals(codePizzaApresMaj)) {
								System.out.println("Erreur : le code " + codePizzaApresMaj + " est déjà pris.");
								codePris = true;
								break;
							}
						}
					}
					
					// succès : saisie des autres infos et màj de la pizza
					if (!codePris) {
						System.out.print("Veuillez saisir le nouveau nom : ");
						String nomPizzaApresMaj = sc.next();
						
						System.out.print("Veuillez saisir le nouveau prix (utiliser , comme séparateur décimal) : ");
						float prixPizzaApresMaj = sc.nextFloat();
						
						pizzas[indexPizzaAMaj] = new Pizza (codePizzaApresMaj, nomPizzaApresMaj, prixPizzaApresMaj);
					}
					
				}
			}
		}
		
	}
	
	public static void supprimerPizza () {

		// aucune pizza : message d'information et sortie immédiate
		if (pizzas.length == 0) {
			System.out.println("Il n'y a aucune pizza dans la base ; pas de suppression possible.");
		} else {
			
			// afficher la liste
			listerPizzas ();
			
			// demander de sélectionner une pizza et lire la saisie clavier
			System.out.println("Veuillez choisir la pizza à supprimer.\n(99 pour abandonner).");
			System.out.println("Code de la pizza à supprimer : ");
			String codePizzaASupprimer = sc.next();
			
			// l'utilisateur abandonne la modification
			if (codePizzaASupprimer.equals("99")) {
				System.out.println("Abandon de la suppression.");
				
			// sinon continuer les saisies
			} else {

				
				// chercher l'index de la pizza à supprimer
				int indexPizzaASupprimer = -1;
				for (int i = 0 ; i < pizzas.length ; i++) {
					if (pizzas[i].code.equals(codePizzaASupprimer)) {
						indexPizzaASupprimer = i;
						break;
					}
				}
				
				// cas d'erreur : code introuvable
				if (indexPizzaASupprimer == -1) {
					System.out.println("Erreur : le code " + codePizzaASupprimer + " est introuvable.");
				} else {

					Pizza[] pizzasApresSuppression = new Pizza[pizzas.length-1];
					
					// créer un nouveau tableau qui ne contient pas l'élément supprimé
					if (indexPizzaASupprimer == 0) { // cas début de liste
						
						for (int i = 1 ; i < pizzas.length ; i++) {
							pizzasApresSuppression[i-1] = pizzas[i];
						}
						
					} else if (indexPizzaASupprimer == (pizzas.length - 1)) { // cas fin de liste

						for (int i = 0 ; i < pizzas.length-1 ; i++) {
							pizzasApresSuppression[i] = pizzas[i];
						}
						
					} else { // cas milieu de liste
						
						// avant l'index de la pizza supprimée
						for (int i = 0 ; i < indexPizzaASupprimer ; i++) {
							pizzasApresSuppression[i] = pizzas[i];
						}
						
						// après l'index
						for (int i = indexPizzaASupprimer+1 ; i < pizzas.length ; i++) {
							pizzasApresSuppression[i-1] = pizzas[i];
						}
						
					}
					
					// remplacement de la liste
					pizzas = pizzasApresSuppression;
				
				}
			}
		}
		
	}
	
	
	/**
	 * Méthode principale.
	 * @param args Arguments du programme.
	 */
	public static void main(String[] args) {
		
		// initialisations
		
		sc = new Scanner(System.in);
		int choix;

		// poursuivre jusqu'à ce que l'utilisateur demande de sortir
		do {

			// menu principal et lecture du choix
			choix = menuPrincipal ();
			
			// tester le choix et agir en conséquences
			switch (choix) {
			
			case 1: // lister les pizzas
				listerPizzas();
				break;
			
			case 2: // ajouter une nouvelle pizza
				ajouterPizza ();
				break;
				
			case 3: // mettre à jour une pizza
				majPizza ();
				break;
				
				
			case 4: // supprimer une pizza
				supprimerPizza ();
				break;
			}

		} while (choix != 99);
		
		// dernières opérations afin la fin du programme
		System.out.println("Au revoir.");
		sc.close();

	}

}
