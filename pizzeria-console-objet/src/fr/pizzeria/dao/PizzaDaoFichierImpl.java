package fr.pizzeria.dao;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.pizzeria.exception.dao.AjouterPizzaException;
import fr.pizzeria.exception.dao.ModifierPizzaException;
import fr.pizzeria.exception.dao.SupprimerPizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoFichierImpl implements IPizzaDao {
	
	
	// ==== Variables ====
	
	/**
	 * Pizzas affich�es � la carte.
	 */
	private Map<String, Pizza> pizzas;
	
	// ==== Constructeurs ====
	
	/**
	 * Cr�er un DAO g�rant une carte de pizzas pr�-remplie.
	 */
	public PizzaDaoFichierImpl() {

		// pizzas existantes
		
		pizzas = new HashMap<String, Pizza> ();
		
		
		File fichier;
		fichier = new File("data");
		
		Path path = fichier.toPath();
		System.out.println(path.getFileName());
		
		
		/*
		for (File f1 : f.listFiles()) {
			
			System.out.println("" + f1.getName());
		}
		*/
		
		/*
		Path p;
		p.
		*/
		
		/*
		Arrays.asList(fichier.listFiles()).stream()
			.filter(f -> (f.isFile() && f.getName().endsWith(".txt")))
			.forEach(
				f -> {
					//Pizza p = new Pizza(f.getName().split(File.pathSeparator)[0].;
				}
			);
			*/
		
		//String code, String nom, double prix, CategoriePizza categorie
					/*
				new Function<String,Pizza> () {

					@Override
					public Pizza apply(String t) {
						return null;
					}
					
				}
				*/
		
		
		
		
		Pizza[] pizzasParDefaut = new Pizza[] {
				new Pizza ("PEP", "Peperoni", 10, CategoriePizza.VIANDE),
				new Pizza ("MAR", "Margherita", 14, CategoriePizza.SANS_VIANDE),
				new Pizza ("REI", "La Reine", 11.5, CategoriePizza.VIANDE),
				new Pizza ("FRO", "La 4 fromages", 12, CategoriePizza.SANS_VIANDE),
				new Pizza ("CAN", "La cannibale", 12.5, CategoriePizza.VIANDE),
				new Pizza ("SAV", "La savoyarde", 13, CategoriePizza.VIANDE),
				new Pizza ("ORI", "L'orientale", 13.5, CategoriePizza.VIANDE),
				new Pizza ("IND", "L'indienne", 14, CategoriePizza.VIANDE),
				new Pizza ("SAU", "La saumoneta", 14, CategoriePizza.POISSON),
			};
			
		
		for (Pizza p : pizzasParDefaut) {
			pizzas.put(p.getCode(), p);
		}
		
		
	}
	
	
	// ==== M�thodes ====

	/**
	 * R�cup�rer la liste des pizzas � la carte.
	 * @return Tableau de Pizza, qui est une copie des pizzas � la carte. 
	 */
	@Override
	public List<Pizza> listePizzas() {
		
		ArrayList<Pizza> copie = new ArrayList<Pizza>();
		copie.addAll(pizzas.values());
		return copie;
		
	}
	
	/**
	 * Ins�rer une nouvelle pizza dans la carte.
	 * @param pizzaAjoutee
	 * @return true si l'ajout r�ussi, false sinon.
	 * @throws AjouterPizzaException 
	 */
	@Override
	public void ajouterPizza(Pizza nouvellePizza) throws AjouterPizzaException {
		
		// le code n'est pas encore pris : ajouter la pizza
		if (! pizzas.containsKey(nouvellePizza.getCode())) {
			pizzas.put(nouvellePizza.getCode(), nouvellePizza);
		} else {
			throw new AjouterPizzaException ("Le code pizza " + nouvellePizza.getCode() + " est d�j� pris.");
		}
		
	}
	
	/**
	 * Modifier la pizza portant le code donn� pour qu'elle prenne les donn�es fournies.
	 * @param codePizza Ancien code de la pizza � modifier.
	 * @param pizzaModifiee Nouvelle valeur de la pizza � modifier.
	 * @return true si la modification a r�ussi, false sinon.
	 * @throws ModifierPizzaException 
	 */
	@Override
	public void modifierPizza(String codePizza, Pizza pizzaApresModification) throws ModifierPizzaException {
		
		if (pizzas.containsKey(codePizza)) {
			// changement de cl� : supprimer l'ancienne instance
			if (! codePizza.equals(pizzaApresModification.getCode())) {
				pizzas.remove(codePizza);
			}
			
			// dans tous les cas, ajouter la nouvelle (�crase l'ancienne si m�me cl�)
			pizzas.put(pizzaApresModification.getCode(), pizzaApresModification);
		} else {
			throw new ModifierPizzaException ("Le code pizza " + codePizza + " est introuvable.");
		}
		
	}

	/**
	 * Supprimer la pizza portant le code donn�.
	 * @param codePizza
	 * @return true si la suppression a r�ussi, false sinon.
	 * @throws SupprimerPizzaException 
	 */
	@Override
	public void supprimerPizza(String codePizza) throws SupprimerPizzaException {
		
		// tenter de supprimer la pizza ; en cas d'�chec, lancer l'exception
		if (pizzas.remove(codePizza) == null) {
			throw new SupprimerPizzaException ("Le code pizza " + codePizza + " est introuvable.");
		}
		
	}
	
	/**
	 * Tester si le code pizza fourni existe d�j� dans la carte.
	 * @param codePizza
	 * @return true si le code a �t� trouv�, false sinon.
	 */
	@Override
	public boolean codePizzaExiste(String codePizza) {
		return pizzas.containsKey(codePizza);
	}
	
	/**
	 * Obtenir la pizza portant le code fourni. 
	 * @param codePizza
	 * @return La pizza portant le code donn�, ou null si le code est introuvable.
	 */
	@Override
	public Pizza trouverPizza(String codePizza) {
		return pizzas.get(codePizza);
		
	}
	

}
