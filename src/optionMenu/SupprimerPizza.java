package optionMenu;

import java.util.Scanner;

import dao.IPizzaDao;

public class SupprimerPizza extends OptionMenu {

	public SupprimerPizza(IPizzaDao dao, Scanner scan) {
		super(dao, scan);

	}

	public void execute() {

		String pizzSupr;
		System.out.println(
				"\n***************choisissez une pizza a supprimer par son code********************************* \n");

		pizzSupr = scan.next();
		dao.supprimerPizza(pizzSupr);

	}
}