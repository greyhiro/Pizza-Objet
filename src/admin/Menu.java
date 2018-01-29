package admin;

import static view.MainPizza.CONSOLE;

import java.util.Scanner;

import dao.DaoJPA;
import dao.IPizzaDao;
import exeption.SavePizzaExeption;
import optionMenu.*;

public class Menu {

	int choix;

	/**
	 * classe de finissant les choix qui vont être effectué sur le menu
	 */
	public Menu() {

		super();

	}
	
	/**
	 * 
	 * @param choix int chiffre entrée en console afin de deffinir l'action que l'on veut effectuer sur le programme
	 * @param dao classe dao recupere la liste de pizza et la traite
	 * @param scan scanner java pour ecouter les choix de l'utilisateur
	 */

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
	/**
	 * affichage du menu
	 * @param scan
	 * @return
	 */

	public int defchoix(Scanner scan) {

		
		CONSOLE.info("\n MENU \n");
		CONSOLE.info("1  ->  Liste des Pizza" + "\n2  ->  Ajout d'une nouvelle pizza"
				+ "\n3  ->  Mise à jour d'une pizza " + "\n4  ->  Suppression d'une pizza" + "\n99 ->  " + "QUITTER");

		return scan.nextInt();

	}

}
