package view;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import admin.Menu;
//import dao.DaoBDD;
//import dao.DaoBDD;
import dao.DaoJPA;
import dao.IPizzaDao;

public class MainPizza {

	public static final Logger CONSOLE = LoggerFactory.getLogger("dev.service");

	public static void main(String[] args) {
		
		

		CONSOLE.info("Bienvenue a la pizzeria");
		int choix;

		choix = 0;
		IPizzaDao p = new DaoJPA();


		Scanner scan = new Scanner(System.in);

		Menu m = new Menu();
		do {
			choix = m.defchoix(scan);
			m.choixMenu(choix, p, scan);
		} while (choix != 99);
	}

}
