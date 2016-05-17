package fr.pizzeria.ihm.menu.option;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import org.apache.commons.collections4.ListUtils;

import fr.pizzeria.dao.factory.DaoFactory;
import fr.pizzeria.dao.pizza.PizzaDaoBddImpl;
import fr.pizzeria.exception.dao.DaoException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class ImporterDonneesOptionMenu extends AbstractOptionMenu {
	
	// ==== Constructeurs ====
	
	public ImporterDonneesOptionMenu(DaoFactory daoFactory) {
		super("Importer données", daoFactory);
	}
	
	
	// ==== Méthodes ====
	
	@Override
	public boolean executer() throws DaoException {
		
		
		// TODO plutôt utiliser les données lues par le Dao Fichier, puis les insérer dans le Dao SQL
		

		ResourceBundle bundle = ResourceBundle.getBundle("application");
		
		if (Integer.valueOf(bundle.getString("dao.impl")) == 2) {
			
			System.out.println("Importation des données...");
			
			
			// lecture des données du répertoire data
			Map<String, Pizza> pizzasLues = new HashMap<String, Pizza>();
			

			// charger à partir du contenu du répertoire "data"
			try {
				
				Files.list(Paths.get("data"))
					.map(path -> {
						Pizza p = new Pizza();
						p.setCode(path.getFileName().toString().replaceAll(".txt",  ""));
						try {
							String ligne = Files.readAllLines(path).get(0);
							String[] ligneTab = ligne.split(";");
							p.setNom(ligneTab[0]);
							p.setPrix(new BigDecimal(ligneTab[1]));
							p.setCategorie(CategoriePizza.valueOf(ligneTab[2]));
						} catch (Exception e) {
							e.printStackTrace();
						}
						return p;
					})
					.collect(Collectors.toList())
					.forEach(p -> pizzasLues.put(p.getCode(), p));
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
			// écriture dans la BDD
			PizzaDaoBddImpl dao = (PizzaDaoBddImpl)(daoFactory.getPizzaDao());
			
			List<List<Pizza>> groupesPizzas = ListUtils.partition(new ArrayList<Pizza>(pizzasLues.values()), 3);
			
			for (List<Pizza> lp : groupesPizzas) {
				dao.ajouterGroupePizzas(lp);
			}
			
			
		} else {
			throw new DaoException("Veuillez configurer l’application avec une implémentation base de données");
		}
		
		return true;
	}
	
}
