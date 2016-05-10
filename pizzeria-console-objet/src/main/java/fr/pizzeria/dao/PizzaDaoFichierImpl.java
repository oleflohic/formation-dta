package fr.pizzeria.dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import fr.pizzeria.exception.dao.AjouterPizzaException;
import fr.pizzeria.exception.dao.ModifierPizzaException;
import fr.pizzeria.exception.dao.SupprimerPizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoFichierImpl implements IPizzaDao {
	
	
	// ==== Variables ====
	
	/**
	 * Pizzas affichées à la carte.
	 */
	private Map<String, Pizza> pizzas;
	
	// ==== Constructeurs ====
	
	/**
	 * Créer un DAO gérant une carte de pizzas pré-remplie.
	 */
	public PizzaDaoFichierImpl() {

		// pizzas existantes
		
		pizzas = new HashMap<String, Pizza> ();
		
		// charger à partir du contenu du répertoire "data"
		try {
			
			Files.list(Paths.get("src/main/resources/data"))
				.map(path -> {
					Pizza p = new Pizza();
					p.setCode(path.getFileName().toString().replaceAll(".txt",  ""));
					try {
						String ligne = Files.readAllLines(path).get(0);
						String[] ligneTab = ligne.split(";");
						p.setNom(ligneTab[0]);
						p.setPrix(Double.valueOf(ligneTab[1]));
						p.setCategorie(CategoriePizza.valueOf(ligneTab[2]));
					} catch (Exception e) {
						e.printStackTrace();
					}
					return p;
				})
				.collect(Collectors.toList())
				.forEach(p -> pizzas.put(p.getCode(), p));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	// ==== Méthodes ====

	/**
	 * Récupérer la liste des pizzas à la carte.
	 * @return Tableau de Pizza, qui est une copie des pizzas à la carte. 
	 */
	@Override
	public List<Pizza> listePizzas() {
		
		ArrayList<Pizza> copie = new ArrayList<Pizza>();
		copie.addAll(pizzas.values());
		return copie;
		
	}
	
	/**
	 * Insérer une nouvelle pizza dans la carte.
	 * @param pizzaAjoutee
	 * @return true si l'ajout réussi, false sinon.
	 * @throws AjouterPizzaException 
	 */
	@Override
	public void ajouterPizza(Pizza nouvellePizza) throws AjouterPizzaException {
		
		// le code n'est pas encore pris : ajouter la pizza
		if (! pizzas.containsKey(nouvellePizza.getCode())) {
			pizzas.put(nouvellePizza.getCode(), nouvellePizza);
			
			// créer le fichier de pizza
			File f = new File("data/" + nouvellePizza.getCode() + ".txt");
			f.setWritable(true);
			try {
				f.createNewFile();
				
				FileWriter fw = new FileWriter(f);
				fw.write(nouvellePizza.getNom() + ";" + nouvellePizza.getPrix() + ";" + nouvellePizza.getCategorie().name());
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else {
			throw new AjouterPizzaException ("Le code pizza " + nouvellePizza.getCode() + " est déjà pris.");
		}
		
	}
	
	/**
	 * Modifier la pizza portant le code donné pour qu'elle prenne les données fournies.
	 * @param codePizza Ancien code de la pizza à modifier.
	 * @param pizzaModifiee Nouvelle valeur de la pizza à modifier.
	 * @return true si la modification a réussi, false sinon.
	 * @throws ModifierPizzaException 
	 */
	@Override
	public void modifierPizza(String codePizza, Pizza pizzaApresModification) throws ModifierPizzaException {
		
		if (pizzas.containsKey(codePizza)) {
			// changement de clé : supprimer l'ancienne instance
			if (! codePizza.equals(pizzaApresModification.getCode())) {
				pizzas.remove(codePizza);
				
				// supprimer l'ancien fichier de pizza
				Paths.get("data/" + codePizza + ".txt").toFile().delete();
				
			}
			
			// dans tous les cas, ajouter la nouvelle (écrase l'ancienne si même clé)
			pizzas.put(pizzaApresModification.getCode(), pizzaApresModification);

			// créer le fichier de pizza
			File f = new File("data/" + pizzaApresModification.getCode() + ".txt");
			f.setWritable(true);
			try {
				f.createNewFile();
				FileWriter fw = new FileWriter(f);
				fw.write(pizzaApresModification.getNom() + ";" + pizzaApresModification.getPrix() + ";" + pizzaApresModification.getCategorie().name());
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		} else {
			throw new ModifierPizzaException ("Le code pizza " + codePizza + " est introuvable.");
		}
		
	}

	/**
	 * Supprimer la pizza portant le code donné.
	 * @param codePizza
	 * @return true si la suppression a réussi, false sinon.
	 * @throws SupprimerPizzaException 
	 */
	@Override
	public void supprimerPizza(String codePizza) throws SupprimerPizzaException {
		
		// tenter de supprimer la pizza ; en cas d'échec, lancer l'exception
		if (pizzas.remove(codePizza) == null) {
			throw new SupprimerPizzaException ("Le code pizza " + codePizza + " est introuvable.");
		}
		Paths.get("data/" + codePizza + ".txt").toFile().delete();
		
	}
	
	/**
	 * Tester si le code pizza fourni existe déjà dans la carte.
	 * @param codePizza
	 * @return true si le code a été trouvé, false sinon.
	 */
	@Override
	public boolean codePizzaExiste(String codePizza) {
		return pizzas.containsKey(codePizza);
	}
	
	/**
	 * Obtenir la pizza portant le code fourni. 
	 * @param codePizza
	 * @return La pizza portant le code donné, ou null si le code est introuvable.
	 */
	@Override
	public Pizza trouverPizza(String codePizza) {
		return pizzas.get(codePizza);
		
	}
	

}
