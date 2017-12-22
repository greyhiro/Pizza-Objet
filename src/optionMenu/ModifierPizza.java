package optionMenu;

import java.util.Scanner;

import admin.Pizza;
import dao.IPizzaDao;

public class ModifierPizza extends OptionMenu {

	String code;
	int i;
	String nom;
	double prix;
	String codepizz;

	public ModifierPizza(IPizzaDao dao, Scanner scan) {
		super(dao, scan);

	}

	public void execute() {

		System.out.println("\n***************Choisissez une pizza par son code********************************* \n");
		codepizz = scan.next();
		if (dao.verifPizzaExiste(codepizz) == true) {

			System.out.println("\n***************Nouveau Code********************************* \n");

			code = scan.next();

			System.out.println("\n***************Nouveau Nom********************************* \n");

			nom = scan.next();

			System.out.println("\n***************Nouveau Prix********************************* \n");

			prix = scan.nextDouble();

			dao.updatePizza(codepizz, new Pizza(code, nom, prix));
		}
	}
}
