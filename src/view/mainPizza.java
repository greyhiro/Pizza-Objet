package view;

import java.util.Scanner;

import admin.Menu;

import dao.Dao;
import dao.IPizzaDao;;

public class mainPizza {

	public static void main(String[] args) {

		int choix;

		choix = 0;
		IPizzaDao p= new Dao();
		
		
		Scanner scan = new Scanner(System.in);

		Menu m = new Menu();
		do {
			choix = m.defchoix(scan);
			m.choixMenu(choix, p, scan);
		} while (choix != 99);
	}

}
