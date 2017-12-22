package dao;

import java.util.List;

import admin.Pizza;

public interface IPizzaDao {

	boolean verifPizzaExiste(String code);

	public List<Pizza> findAllPizzas();

	void saveNewPizza(Pizza pizza);

	boolean supprimerPizza(String pizzSupr);

	boolean updatePizza(String codePizza, Pizza pizza);

}