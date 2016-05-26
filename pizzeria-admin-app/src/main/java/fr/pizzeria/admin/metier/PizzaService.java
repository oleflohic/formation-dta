package fr.pizzeria.admin.metier;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.pizzeria.model.Pizza;

@Stateless
public class PizzaService {
	
	//@Inject @Named("pizzaDaoImpl") IPizzaDao pizzaDao;
	
	@PersistenceContext(unitName="pizzeria-admin-app") private EntityManager em;
	
	// ==== Variables ====
	/*
	protected String url;
	protected String utilisateur;
	protected String mdp;
	*/
	
	
	// ==== Méthodes ====
	
	
	@SuppressWarnings("unchecked")
	public List<Pizza> listePizzas() {
		return (List<Pizza>)em.createQuery("SELECT p FROM Pizza p").getResultList();
		/*
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
		*/
		
		//return pizzaDao.listePizzas();
	}
	
	public Pizza trouverPizza(String codePizza) {
		return (Pizza)em.createQuery("SELECT p FROM Pizza p WHERE code='" + codePizza + "'").getSingleResult();
		
/*
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
		*/
		
		//return pizzaDao.trouverPizza(codePizza);
	}
	
	/*
	new PizzaDaoBddImpl(jdbcBundle.getString("jdbc.driver"), 
		"jdbc:" + jdbcBundle.getString("jdbc.dbtype") + "://" + jdbcBundle.getString("jdbc.host") + ":"
				+ jdbcBundle.getString("jdbc.port") + "/" + jdbcBundle.getString("jdbc.dbname"),
		jdbcBundle.getString("jdbc.username"),
		jdbcBundle.getString("jdbc.password")
	));
	*/
	
	
	// @Schedule(second="*/10", minute="*", hour="*")
	/*
	public void rdmPizza () {
		try {
			System.out.println("AJOUT PIZZA");
			pizzaDao.ajouterPizza(new Pizza("" + (int)(Math.random()*1000), "randompizza", BigDecimal.ZERO, CategoriePizza.SANS_VIANDE, ""));
			System.out.println("> " + pizzaDao.listePizzas().size());
			
		} catch (AjouterPizzaException e) {
			e.printStackTrace();
			System.out.println("echec ajout");
		}
	}
	*/
	
	
	
	
}
