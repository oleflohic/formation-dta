package fr.pizzeria.console;

import java.util.Scanner;
import fr.pizzeria.model.Pizza;

/**
 * Utilis� pour g�rer un menu de pizzeria. (affichage d'information, op�rations de cr�ation/�dition/suppression/m�j.
 * @author oleflohic
 */
public class MenuPizzeria {
	
	// VARIABLES
	
	private Scanner scanner;
	private Pizza[] pizzas;
	
	private OptionMenu[] options;
	
	// CONSTRUCTEURS
	
	public MenuPizzeria (Scanner scanner) {
		this (scanner, genererPizzasParDefaut());
	}
	
	public MenuPizzeria (Scanner scanner, Pizza[] pizzas) {
		this.scanner = scanner;
		this.pizzas = pizzas;
		
		options = new OptionMenu[] {
				new ListerPizzasOptionMenu("Lister les pizzas"),
				new AjouterPizzaOptionMenu("Ajouter une nouvelle pizza"),
				new MajPizzaOptionMenu("Mettre � jour une pizza"),
				new SupprimerPizzaOptionMenu("Supprimer une pizza"),
			};
	}
	
	// CLASSES
	
	private static abstract class OptionMenu {
		private String libelle;
		public OptionMenu (String libelle) {
			this.libelle = libelle;
		}
		abstract boolean executer ();
	}

	
	private static class ListerPizzasOptionMenu extends OptionMenu {
		public ListerPizzasOptionMenu(String libelle) {
			super(libelle);
		}

		@Override
		boolean executer () {

			/*
			System.out.println();
			System.out.println("Liste des pizzas :");
			
			// aucune pizza : message d'information
			if (pizzas.length == 0) {
				System.out.println("Il n'y a aucune pizza dans la base.");
			} else {
				
				for (int i = 0 ; i < pizzas.length ; i++) {
					System.out.println("" + pizzas[i].code + " -> " + pizzas[i].nom + " (" + pizzas[i].prix + "�)");
				}
				
				// afficher le nombre de pizzas cr�es depuis le d�but. grammaire en bonus.
				if (Pizza.nbPizzas > 1) {
					System.out.println("------- " + Pizza.nbPizzas + " pizzas cr��es depuis l�initialisation du programme");
				} else {
					System.out.println("------- " + Pizza.nbPizzas + " pizza cr��e depuis l�initialisation du programme");
				}
			}
			*/
			
			return true;
		}
	}
	
	private static class AjouterPizzaOptionMenu extends OptionMenu {
		public AjouterPizzaOptionMenu(String libelle) {
			super(libelle);
		}

		@Override
		boolean executer () {
			
			return true;
		}
	}
	
	private static class MajPizzaOptionMenu extends OptionMenu {
		public MajPizzaOptionMenu(String libelle) {
			super(libelle);
		}

		@Override
		boolean executer () {
			
			return true;
		}
	}
	
	private static class SupprimerPizzaOptionMenu extends OptionMenu {
		public SupprimerPizzaOptionMenu(String libelle) {
			super(libelle);
		}

		@Override
		boolean executer () {
			
			return true;
		}
	}
	
	// METHODES STATIQUES
	
	public static Pizza[] genererPizzasParDefaut () {
		// pizzas existantes
		return new Pizza[] {
				new Pizza ("PEP", "Peperoni", 10),
				new Pizza ("MAR", "Margherita", 14),
				new Pizza ("REI", "La Reine", 11.5),
				new Pizza ("FRO", "La 4 fromages", 12),
				new Pizza ("CAN", "La cannibale", 12.5),
				new Pizza ("SAV", "La savoyarde", 13),
				new Pizza ("ORI", "L'orientale", 13.5),
				new Pizza ("IND", "L'indienne", 14),
			};
	}
	
	
	// METHODES
	
	public void executerChoix (int choix) {

		/*
		// tester le choix et agir en cons�quences
		switch (choix) {
		
		case 1: // lister les pizzas
			listerPizzas();
			break;
		
		case 2: // ajouter une nouvelle pizza
			ajouterPizza ();
			break;
			
		case 3: // mettre � jour une pizza
			majPizza ();
			break;
			
			
		case 4: // supprimer une pizza
			supprimerPizza ();
			break;
			
		case 99:
			System.out.println("Au revoir.");
			break;
		}
		*/
		
		if (choix != 99) {
			options[choix].executer();
		} else {
			System.out.println("Au revoir.");
		}
		
	}
	
	/**
	 * afficher le menu principale ET demander � l'utilisateur de choisir une valeur.
	 * @return l'entier saisi par l'utilisateur, qui correspond � l'action choisie.
	 */
	public int menuPrincipal () {

		// menu principal et lecture du choix
		
		/*
		System.out.println (
			"***** Pizzeria Administration *****\n"
			+ " 1. Lister les pizzas\n"
			+ " 2. Ajouter une nouvelle pizza\n"
			+ " 3. Mettre � jour une pizza\n"
			+ " 4. Supprimer une pizza\n"
			+ "99. Sortir"
		);
		*/
		System.out.println ("***** Pizzeria Administration *****\n");

		for (int i = 0 ; i < options.length ; i++) {
			System.out.println("" + i + ". " + options[i].libelle);
		}
		System.out.println("99. Sortir");
		
		System.out.print("Choix : ");
		return scanner.nextInt();
		
	}
	
	/**
	 * afficher les pizzas existantes
	 */
	public void listerPizzas () {
		
		System.out.println();
		System.out.println("Liste des pizzas :");
		
		// aucune pizza : message d'information
		if (pizzas.length == 0) {
			System.out.println("Il n'y a aucune pizza dans la base.");
		} else {
			
			for (int i = 0 ; i < pizzas.length ; i++) {
				System.out.println("" + pizzas[i].code + " -> " + pizzas[i].nom + " (" + pizzas[i].prix + "�)");
			}
			
			// afficher le nombre de pizzas cr�es depuis le d�but. grammaire en bonus.
			if (Pizza.nbPizzas > 1) {
				System.out.println("------- " + Pizza.nbPizzas + " pizzas cr��es depuis l�initialisation du programme");
			} else {
				System.out.println("------- " + Pizza.nbPizzas + " pizza cr��e depuis l�initialisation du programme");
			}
		}
		
	}
	
	
	/**
	 * ajouter une nouvelle pizza � la liste des pizzas existantes.
	 */
	public void ajouterPizza () {

		System.out.print("Veuillez saisir le code : ");
		String codePizzaAjoutee = scanner.next();

		// tester si le code est pris
		boolean codePris = false;
		for (int i = 0 ; i < pizzas.length ; i++) {
			if (pizzas[i].code.equals(codePizzaAjoutee)) {
				System.out.println("Erreur : le code " + codePizzaAjoutee + " est d�j� pris.");
				codePris = true;
				break;
			}
		}
		
		
		// s'il n'est pas pris, saisir les informations suppl�mentaires et ajouter la pizza
		if (!codePris) {
			
			System.out.print("Veuillez saisir le nom : ");
			String nomPizzaAjoutee = scanner.next();
			
			System.out.print("Veuillez saisir le prix (utiliser , comme s�parateur d�cimal) : ");
			float prixPizzaAjoutee = scanner.nextFloat();
			
			Pizza pizzaAjoutee = new Pizza (codePizzaAjoutee, nomPizzaAjoutee, prixPizzaAjoutee);
			Pizza[] pizzasApresAjout = new Pizza[pizzas.length+1];
			// copier le contenu de la vieille liste dans la nouvelle,
			// puis mettre la nouvelle pizza � sa fin
			for (int i = 0 ; i < pizzas.length ; i++) {
				pizzasApresAjout[i] = pizzas[i];
			}
			pizzasApresAjout[pizzas.length] = pizzaAjoutee;
			pizzas = pizzasApresAjout;
		}
		
	}

	/**
	 * mettre-�-jour (m�j) une pizza en demandant � l'utilisateur de saisir les informations requises
	 */
	public void majPizza () {

		// aucune pizza : message d'information et sortie imm�diate
		if (pizzas.length == 0) {
			System.out.println("Il n'y a aucune pizza dans la base ; pas de mise-�-jour possible.");
		} else {
		
			// afficher la liste
			listerPizzas ();
			
			// demander de s�lectionner une pizza et lire la saisie clavier
			System.out.println("Veuillez choisir la pizza � modifier.\n(99 pour abandonner).");
			System.out.println("Code de la pizza � modifier : ");
			String codePizzaAMaj = scanner.next();
			
			// l'utilisateur abandonne la modification
			if (codePizzaAMaj.equals("99")) {
				System.out.println("Abandon de la mise-�-jour.");
				
			// sinon continuer les saisies
			} else {

				// chercher l'index de la pizza � m�j
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
					
					// m�j des infos
					System.out.print("Veuillez saisir le nouveau code : ");
					String codePizzaApresMaj = scanner.next();
					

					// cas d'erreur : code d�j� pris
					boolean codePris = false;
					if (!codePizzaAMaj.equals(codePizzaApresMaj)) {
						for (int i = 0 ; i < pizzas.length ; i++) {
							if (pizzas[i].code.equals(codePizzaApresMaj)) {
								System.out.println("Erreur : le code " + codePizzaApresMaj + " est d�j� pris.");
								codePris = true;
								break;
							}
						}
					}
					
					// succ�s : saisie des autres infos et m�j de la pizza
					if (!codePris) {
						System.out.print("Veuillez saisir le nouveau nom : ");
						String nomPizzaApresMaj = scanner.next();
						
						System.out.print("Veuillez saisir le nouveau prix (utiliser , comme s�parateur d�cimal) : ");
						float prixPizzaApresMaj = scanner.nextFloat();
						
						pizzas[indexPizzaAMaj] = new Pizza (codePizzaApresMaj, nomPizzaApresMaj, prixPizzaApresMaj);
					}
					
				}
			}
		}
		
	}
	
	/**
	 * supprimer une pizza de la liste des pizzas existantes.
	 */
	public void supprimerPizza () {

		// aucune pizza : message d'information et sortie imm�diate
		if (pizzas.length == 0) {
			System.out.println("Il n'y a aucune pizza dans la base ; pas de suppression possible.");
		} else {
			
			// afficher la liste
			listerPizzas ();
			
			// demander de s�lectionner une pizza et lire la saisie clavier
			System.out.println("Veuillez choisir la pizza � supprimer.\n(99 pour abandonner).");
			System.out.println("Code de la pizza � supprimer : ");
			String codePizzaASupprimer = scanner.next();
			
			// l'utilisateur abandonne la modification
			if (codePizzaASupprimer.equals("99")) {
				System.out.println("Abandon de la suppression.");
				
			// sinon continuer les saisies
			} else {

				
				// chercher l'index de la pizza � supprimer
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
					
					// cr�er un nouveau tableau qui ne contient pas l'�l�ment supprim�
					if (indexPizzaASupprimer == 0) { // cas d�but de liste
						
						for (int i = 1 ; i < pizzas.length ; i++) {
							pizzasApresSuppression[i-1] = pizzas[i];
						}
						
					} else if (indexPizzaASupprimer == (pizzas.length - 1)) { // cas fin de liste

						for (int i = 0 ; i < pizzas.length-1 ; i++) {
							pizzasApresSuppression[i] = pizzas[i];
						}
						
					} else { // cas milieu de liste
						
						// avant l'index de la pizza supprim�e
						for (int i = 0 ; i < indexPizzaASupprimer ; i++) {
							pizzasApresSuppression[i] = pizzas[i];
						}
						
						// apr�s l'index
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
	
	
}
