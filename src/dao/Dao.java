package dao;

import java.util.ArrayList;

import java.util.List;

import admin.Pizza;

public class Dao implements IPizzaDao {

	private List<Pizza> p = new ArrayList<Pizza>();

	public Dao() {

		p.add(new Pizza("PEP", "Pépéroni", 12.50));
		p.add(new Pizza("MAR", "Margherita", 14.00));
		p.add(new Pizza("REIN", "Reine", 14.00));
		p.add(new Pizza("FRO", "La 4 fromages", 12.00));
		p.add(new Pizza("CAN", "La cannibale", 12.50));
		p.add(new Pizza("SAV", "La savoyarde", 13.00));
		p.add(new Pizza("ORI", "L’orientale", 13.50));

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

				System.out.println("Vous avez choisi: " + code + "\npizza: " + p.get(i).getNom());

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
				break;
			}
		}
		// System.out.println(pizza.getId() + " " + pizza.getCode() + " " +
		// p[i].getNom() + " " + p[i].getPrix());

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.IPizzaDao#supprimerPizza(java.lang.String)
	 */
	@Override
	public boolean supprimerPizza(String pizzSupr) {
		boolean existe;
		existe = true;
		int i;
		if (verifPizzaExiste(pizzSupr) == true) {
			System.out.println("la pizza " + pizzSupr + " a été supprimé");
			for (i = 0; i < p.size(); i++) {

				if ((p.get(i) != null) && (p.get(i).getCode().equals(pizzSupr)) && (p != null)) {

					p.set(i, null);
					existe = true;

				}
			}
		} else {
			System.out.println("la pizza n'existe malheureusement pas rien ne seras supprimé");
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
