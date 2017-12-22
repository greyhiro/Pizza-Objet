package admin;

import java.util.Scanner;

import dao.IPizzaDao;
import exeption.SavePizzaExeption;
import optionMenu.*;

public class Menu {

	int choix;

	public Menu() {

		super();

	}

	public void choixMenu(int choix, IPizzaDao dao, Scanner scan) {

		switch (choix) {

		case 1:
			ListerPizza l = new ListerPizza(dao, scan);
			l.execute();
			break;
		case 2:
			AjouterPizza add = new AjouterPizza(dao, scan);
			try {
				add.execute();
			} catch (SavePizzaExeption e) {
				System.out.println(e.getMessage());
			}
			break;
		case 3:
			ModifierPizza modif = new ModifierPizza(dao, scan);
			modif.execute();

			break;
		case 4:
			SupprimerPizza supr = new SupprimerPizza(dao, scan);
			supr.execute();
			break;

		case 99:
			System.out.println("Au revoir !");
		}

	}

	public int defchoix(Scanner scan) {

		System.out.println("\n***************Bienvenue à la pizzeria********************************* \n");
		System.out.println("\n MENU \n");
		System.out.println("1  ->  Liste des Pizza" + "\n2  ->  Ajout d'une nouvelle pizza"
				+ "\n3  ->  Mise à jour d'une pizza " + "\n4  ->  Suppression d'une pizza" + "\n99 ->  " + "QUITTER");

		return scan.nextInt();

	}

}
