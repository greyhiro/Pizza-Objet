package dao;

import java.util.List;

import admin.Pizza;

/**
 * Interface pour toutes les Dao
 * @author greyhiro
 *
 */
public interface IPizzaDao {

	public boolean verifPizzaExiste(String code);

	public List<Pizza> findAllPizzas();

	public void saveNewPizza(Pizza pizza);

	public boolean supprimerPizza(String pizzSupr);

	public boolean updatePizza(String codePizza, Pizza pizza);

}