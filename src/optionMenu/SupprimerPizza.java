package optionMenu;

import static view.MainPizza.CONSOLE;

import java.util.Scanner;

import dao.IPizzaDao;


/**
 * Communication avec l'utilisateur qui veut supprimer une pizza
 * 
 */
public class SupprimerPizza extends OptionMenu {

	public SupprimerPizza(IPizzaDao dao, Scanner scan) {
		super(dao, scan);

	}

	public void execute() {

		String pizzSupr;
		CONSOLE.info(
				"\n***************choisissez une pizza a supprimer par son code********************************* \n");

		pizzSupr = scan.next();
		dao.supprimerPizza(pizzSupr);

	}
}