package dao;

import static view.MainPizza.CONSOLE;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

import org.junit.Test;

import admin.CategoriePizza;
import admin.Pizza;

public class DaoBDD implements IPizzaDao {

	public boolean verifPizzaExiste(String code) {

		// boucle qui parcours le tableau de Pizza

		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://bl0ljffzh-mysql.services.clever-cloud.com:3306/bl0ljffzh?useSSL=false",
					"uhnbfmjrvzio9n4v", "OOAmlvegpmPAqLlFMb7");
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM pizzas");

			while (result.next()) {

				String code1 = result.getString("code");

				if (code.equals(code1)) {
					CONSOLE.info("elle existe !");
					return true;
				}
			}

			result.close();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CONSOLE.info(code + "n'existe malheureuesment pas dans la BDD \nChoisissez s'en une autre");
		return false;

	}

	@Test
	public List<Pizza> findAllPizzas() {
		List<Pizza> pizza = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://bl0ljffzh-mysql.services.clever-cloud.com:3306/bl0ljffzh?useSSL=false",
					"uhnbfmjrvzio9n4v", "OOAmlvegpmPAqLlFMb7");
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM pizzas");

			while (result.next()) {
				Integer id = result.getInt("ID");
				String code = result.getString("code");
				String name = result.getString("nom");
				BigDecimal price = result.getBigDecimal("prix");
				String cat = result.getString("cat");

				CategoriePizza categ = CategoriePizza.valueOf(cat);

				Pizza p = new Pizza(id, code, name, price, categ);
				pizza.add(p);

			}

			result.close();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return pizza;
	}

	@Test
	public void saveNewPizza(Pizza pizza) {

		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://bl0ljffzh-mysql.services.clever-cloud.com:3306/bl0ljffzh?useSSL=false",
					"uhnbfmjrvzio9n4v", "OOAmlvegpmPAqLlFMb7");

			String code = pizza.getCode();
			String nom = pizza.getNom();
			double prix = pizza.getPrix();
			CategoriePizza cate = pizza.getCat();

			PreparedStatement addPizza = connection
					.prepareStatement("INSERT INTO pizzas(code,nom,prix,cat) Values (?, ?, ?, ?)");

			addPizza.setString(1, code);
			addPizza.setString(2, nom);
			addPizza.setDouble(3, prix);
			addPizza.setString(4, cate.name());
			addPizza.execute();
			addPizza.close();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public boolean supprimerPizza(String pizzSupr) {

		try {

			Class.forName("com.mysql.jdbc.Driver");

			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://bl0ljffzh-mysql.services.clever-cloud.com:3306/bl0ljffzh?useSSL=false",
					"uhnbfmjrvzio9n4v", "OOAmlvegpmPAqLlFMb7");

			PreparedStatement suprPizza = connection.prepareStatement("DELETE FROM pizzas WHERE code LIKE ?");

			suprPizza.setString(1, pizzSupr);
			suprPizza.executeUpdate();
			suprPizza.close();

			return true;

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	@Test
	public boolean updatePizza(String codePizza, Pizza pizza) {

		try {

			Class.forName("com.mysql.jdbc.Driver");

			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://bl0ljffzh-mysql.services.clever-cloud.com:3306/bl0ljffzh?useSSL=false",
					"uhnbfmjrvzio9n4v", "OOAmlvegpmPAqLlFMb7");

			String code = pizza.getCode();
			String nom = pizza.getNom();
			double prix = pizza.getPrix();
			CategoriePizza cate = pizza.getCat();

			PreparedStatement updatePizzaSt = connection
					.prepareStatement("UPDATE pizzas SET code=?, nom=?,prix=?, cat=? WHERE code LIKE ?");

			updatePizzaSt.setString(1, code);
			updatePizzaSt.setString(2, nom);
			updatePizzaSt.setDouble(3, prix);
			updatePizzaSt.setString(4, cate.name());
			updatePizzaSt.setString(5, codePizza);
			updatePizzaSt.executeUpdate();
			updatePizzaSt.close();
			return true;

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

}
