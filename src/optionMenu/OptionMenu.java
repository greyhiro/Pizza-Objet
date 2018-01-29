package optionMenu;

import java.util.Scanner;

import dao.IPizzaDao;
import exeption.StockageException;

/**
 * Classe abstraite qui definit les action du menu avec des methode Overidable
 * @author ETY23
 *
 */
public abstract class OptionMenu {

	protected IPizzaDao dao;
	protected Scanner scan;

	public OptionMenu(IPizzaDao dao, Scanner scan) {
		super();
		this.dao = dao;
		this.scan = scan;
	}

	public abstract void execute() throws StockageException;

}
