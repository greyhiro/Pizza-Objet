package optionMenu;

import static view.MainPizza.CONSOLE;

import java.util.Scanner;

import admin.CategoriePizza;
import admin.Pizza;
import dao.IPizzaDao;
import exeption.SavePizzaExeption;

public class AjouterPizza extends OptionMenu {

	public AjouterPizza(IPizzaDao dao, Scanner scan) {
		super(dao, scan);
	}

	public void execute() throws SavePizzaExeption {


		CONSOLE.info("\n***************AJOUTER PIZZA********************************* \n");

		CONSOLE.info("\n***************Choisissez son Code********************************* \n");

		String code = scan.next();

		if (code.length() != 3) {
			throw new SavePizzaExeption("Le code dois comporter seulement trois lettres");
		}

		if (!code.equals(code.toUpperCase())) {
			throw new SavePizzaExeption("le code dois etre en majuscule");
		}
		CONSOLE.info("\n***************Choisissez son Nom********************************* \n");

		String nom = scan.next();

		CONSOLE.info("\n***************Choisissez son Prix********************************* \n");

		double prix = scan.nextDouble();

		if (prix <= 0) {
			throw new SavePizzaExeption("le prix ne dois pas être négatif");
		}

		CONSOLE.info("\n***************Choisissez une categorie********************************* \n");
		CONSOLE.info("\n1->VIANDE" + "\n2->POISSON" + "\n3->SANS VIANDE");

		int choixcat = scan.nextInt();

		CategoriePizza cat = null;
		if (choixcat == 1) {

			cat = CategoriePizza.VIANDE;
			dao.saveNewPizza(new Pizza(code, nom, prix, cat));
		}
		if (choixcat == 2) {
			cat = CategoriePizza.POISSON;
			dao.saveNewPizza(new Pizza(code, nom, prix, cat));
		}

		if (choixcat == 3) {
			cat = CategoriePizza.SANS_VIANDE;
			dao.saveNewPizza(new Pizza(code, nom, prix, cat));
		}

	}

}
