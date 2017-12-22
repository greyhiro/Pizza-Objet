package optionMenu;

import java.util.Scanner;

import dao.IPizzaDao;
import exeption.StockageException;

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
