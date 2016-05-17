package fr.pizzeria.dao.pizza;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.exception.dao.AjouterPizzaException;
import fr.pizzeria.exception.dao.DaoException;
import fr.pizzeria.exception.dao.ModifierPizzaException;
import fr.pizzeria.exception.dao.SupprimerPizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;



// TODO nettoyage

public class PizzaDaoBddImpl implements IPizzaDao {

	// ==== Variables ====
	protected String url;
	protected String utilisateur;
	protected String mdp;
	
	// ==== Constructeurs ====
	
	public PizzaDaoBddImpl (String pilote, String url, String utilisateur, String mdp) throws DaoException {
		
		try {
			Class.forName(pilote);
			this.url = url;
			this.utilisateur = utilisateur;
			this.mdp = mdp;
		} catch (ClassNotFoundException e) {
			throw new DaoException(e);
		}
		
	}
	
	// ==== Méthodes ====
	
	private Connection getConnection () throws SQLException {
		return DriverManager.getConnection(url, utilisateur, mdp);
	}
	
	// ==== Méthodes ====
	
	@Override
	public List<Pizza> listePizzas() {
		
		try {
			ArrayList<Pizza> resultat = new ArrayList<Pizza>();
			
			Connection c = getConnection();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM pizza");
			
			while (rs.next()) {
				resultat.add(new Pizza(rs.getInt("id"), rs.getString("code"), rs.getString("libelle"), new BigDecimal(rs.getDouble("prix")), CategoriePizza.valueOf(rs.getString("categorie"))));
			}

			rs.close();
			s.close();
			c.close();
			
			return resultat;
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erreur : échec d'accès à la base.");
			return new ArrayList<Pizza>();
		}
	}

	@Override
	public void ajouterPizza(Pizza pizzaAjoutee) throws AjouterPizzaException {
		
		try {
			Connection c = getConnection();
			PreparedStatement ps = c.prepareStatement("INSERT INTO pizza (code, libelle, prix, categorie) VALUES (?, ?, ?, ?)");
			ps.setString(1, pizzaAjoutee.getCode());
			ps.setString(2, pizzaAjoutee.getNom());
			ps.setDouble(3, pizzaAjoutee.getPrix().longValueExact());
			ps.setString(4, pizzaAjoutee.getCategorie().name());
			ps.executeUpdate();
			
			ps.close();
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AjouterPizzaException ("Échec de l'opération ; le code \"" + pizzaAjoutee.getCode() + "\" serait déjà pris.");
			//System.out.println("Erreur : échec de l'opération (connexion ou insertion).");
		}
		
	}

	@Override
	public void modifierPizza(String codePizza, Pizza pizzaModifiee) throws ModifierPizzaException {

		try {
			Connection c = getConnection();
			Statement s = c.createStatement();
			
			s.executeUpdate(
					"UPDATE pizza"
					+ "SET"
						+ "code = " + "'" + pizzaModifiee.getCode() + "'"
						+ "libelle = " + "'" + pizzaModifiee.getNom() + "'"
						+ "prix = " + "'" + pizzaModifiee.getPrix() + "'"
						+ "categorie = " + "'" + pizzaModifiee.getCategorie().name() + "'"
					+ "WHERE code = " + "'" + codePizza + "'"
				);
			
			s.close();
			c.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erreur : échec de l'opération (connexion ou insertion).");
		}
		
		
		
	}

	@Override
	public void supprimerPizza(String codePizza) throws SupprimerPizzaException {

		try {
			
			Connection c = getConnection();
			Statement s = c.createStatement();
			int count = s.executeUpdate(
					"DELETE FROM pizza "
					+ "WHERE code = " + "'" + codePizza + "'"
				);
			
			System.out.println("suppr : " + count + " entrée(s)");
			
			s.close();
			c.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erreur : échec de l'opération (connexion ou insertion).");
		}
		
	}

	@Override
	public boolean codePizzaExiste(String codePizza) {
		return trouverPizza(codePizza) != null;
	}

	@Override
	public Pizza trouverPizza(String codePizza) {
		
		try {
			Connection c = getConnection();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM pizza WHERE code = '" + codePizza + "'");
			
			while (rs.next()) {
				Pizza p = new Pizza(rs.getInt("id"), rs.getString("code"), rs.getString("libelle"), new BigDecimal(rs.getDouble("prix")), CategoriePizza.valueOf(rs.getString("categorie")));
				rs.close();
				s.close();
				c.close();
				return p;
			}

			rs.close();
			s.close();
			c.close();
			
			return null;
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erreur : échec d'accès à la base.");
			return null;
		}
	}
	
	
	public void ajouterGroupePizzas (List<Pizza> pizzasAInserer) {
		
		try {
			Connection c = getConnection();
			c.setAutoCommit(false);
			PreparedStatement ps = c.prepareStatement("INSERT INTO pizza (code, libelle, prix, categorie) VALUES (?, ?, ?, ?)");
			
			try {
				for (Pizza p : pizzasAInserer) {
					ps.setString(1, p.getCode());
					ps.setString(2, p.getNom());
					ps.setDouble(3, p.getPrix().longValueExact());
					ps.setString(4, p.getCategorie().name());
					ps.executeUpdate();
				}
				c.commit();
				c.setAutoCommit(true);
				ps.close();
				c.close();
				
			} catch (SQLException e) {
				c.rollback();
				ps.close();
				c.close();
				throw e;	
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erreur : échec d'accès à la base.");
		}
		
	}
	
}
