package dao;

import static view.mainPizza.CONSOLE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;

import admin.CategoriePizza;
import admin.Pizza;

public class Dao implements IPizzaDao {

	protected List<Pizza> p = new ArrayList<Pizza>();

	public Dao() {

		p.add(new Pizza("PEP", "Pépéroni", 12.50, CategoriePizza.VIANDE));
		p.add(new Pizza("MAR", "Margherita", 14.00,CategoriePizza.SANS_VIANDE));
		p.add(new Pizza("REIN", "Reine", 14.00,CategoriePizza.SANS_VIANDE ));
		p.add(new Pizza("FRO", "La 4 fromages", 12.00,CategoriePizza.SANS_VIANDE ));
		p.add(new Pizza("CAN", "La cannibale", 12.50, CategoriePizza.VIANDE ));
		p.add(new Pizza("SAV", "La savoyarde", 13.00, CategoriePizza.SANS_VIANDE));
		p.add(new Pizza("ORI", "L’orientale", 13.50, CategoriePizza.POISSON));

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IPizzaDao#verifPizzaExiste(java.lang.String)
	 */
	@Override
	public boolean verifPizzaExiste(String code) {

		int i;
		boolean existe;
		existe = false;

		// boucle qui parcours le tableau de Pizza

		for (i = 0; i < p.size(); i++) {

			if ((p != null) && (p.get(i).getCode().equals(code))) {

				CONSOLE.info("Vous avez choisi: " + code + "\npizza: " + p.get(i).getNom());

				existe = true;

			}

		}

		return existe;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IPizzaDao#findAllPizzas()
	 */
	@Override
	public List<Pizza> findAllPizzas() {

		return p;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IPizzaDao#saveNewPizza(admin.Pizza)
	 */
	@Override
	public void saveNewPizza(Pizza pizza) {

		for (int i = 0; i < p.size(); i++) {

			if (p.get(i) == null) {
				p.set(i, pizza);
				

			}
			 
		}
	

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IPizzaDao#supprimerPizza(java.lang.String)
	 */
	@Override
	public boolean supprimerPizza(String pizzSupr)  {
		boolean existe;
		existe = true;
		int i;
		if (verifPizzaExiste(pizzSupr) == true) {
			CONSOLE.info("la pizza " + pizzSupr + " a été supprimé");
			for (i = 0; i < p.size(); i++) {

				if ((p.get(i) != null) && (p.get(i).getCode().equals(pizzSupr)) && (p != null)) {

					p.set(i, null);
					existe = true;

				}
			}
		} else {
			CONSOLE.info("la pizza n'existe malheureusement pas rien ne seras supprimé");
			existe = false;

		}
		return existe;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IPizzaDao#updatePizza(java.lang.String, admin.Pizza)
	 */
	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) {

		boolean existe;
		existe = true;
		int i;

		for (i = 0; i < p.size(); i++) {

			if ((p.get(i) != null) && (p.get(i).getCode().equals(codePizza))) {
				p.set(i, pizza);

				existe = true;
			}

		}

		return existe;
	}
	


}
