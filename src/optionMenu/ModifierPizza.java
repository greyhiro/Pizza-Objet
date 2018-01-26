package optionMenu;

import static view.MainPizza.CONSOLE;

import java.util.Scanner;

import admin.CategoriePizza;
import admin.Pizza;
import dao.IPizzaDao;

public class ModifierPizza extends OptionMenu {

	String code;
	int i;
	String nom;
	double prix;
	String codepizz;
	CategoriePizza cat;
	int choixcat;
	

	public ModifierPizza(IPizzaDao dao, Scanner scan) {
		super(dao, scan);

	}

	public void execute() {

		CONSOLE.info("\n***************Choisissez une pizza par son code********************************* \n");
		codepizz = scan.next();
		if (dao.verifPizzaExiste(codepizz) == true) {

			CONSOLE.info("\n***************Nouveau Code********************************* \n");

			code = scan.next();

			CONSOLE.info("\n***************Nouveau Nom********************************* \n");

			nom = scan.next();

			CONSOLE.info("\n***************Nouveau Prix********************************* \n");

			prix = scan.nextDouble();

			CONSOLE.info("\n***************Choisissez une categorie********************************* \n");
			CONSOLE.info("\n1->VIANDE"
					+ "\n2->POISSON"
					+"\n3->SANS VIANDE");
			
			choixcat= scan.nextInt();
			if(choixcat==1)
			{
				
				cat=CategoriePizza.VIANDE;
				dao.updatePizza(codepizz, new Pizza(code, nom, prix, cat));
			}
			if(choixcat==2)
			{
				cat=CategoriePizza.POISSON;
				dao.updatePizza(codepizz, new Pizza(code, nom, prix, cat));
			}
			
			if(choixcat==3)
			{
				cat=CategoriePizza.SANS_VIANDE;
				dao.updatePizza(codepizz, new Pizza(code, nom, prix, cat));
			}
			
			

		
		}
	}
}
