package optionMenu;


import java.util.Scanner;
import admin.Pizza;
import dao.IPizzaDao;
import exeption.SavePizzaExeption;

public class AjouterPizza extends OptionMenu {

	public AjouterPizza(IPizzaDao dao, Scanner scan) {
		super(dao, scan);
	}

	public void execute() throws SavePizzaExeption {

		String code;
		String nom;
		double prix;

		System.out.println("\n***************AJOUTER PIZZA********************************* \n");

		System.out.println("\n***************Choisissez son Code********************************* \n");
		
		code = scan.next();
		
		if (code.length()!=3) {
			throw new SavePizzaExeption("Le code dois comporter seulement trois lettres");
		}
		
		if(!code.equals(code.toUpperCase()))
		{
			throw new SavePizzaExeption("le code dois etre en majuscule");
		}
		System.out.println("\n***************Choisissez son Nom********************************* \n");

		nom = scan.next();

		System.out.println("\n***************Choisissez son Prix********************************* \n");

		prix = scan.nextDouble();
		
		if(prix<=0)
		{
			throw new SavePizzaExeption("le prix ne dois pas être négatif");
		}

		dao.saveNewPizza(new Pizza(code, nom, prix));
	}
}
