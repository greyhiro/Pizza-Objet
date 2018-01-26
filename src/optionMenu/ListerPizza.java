package optionMenu;


import java.util.List;
import java.util.Scanner;

import admin.Pizza;
import dao.IPizzaDao;

public class ListerPizza extends OptionMenu {

	public ListerPizza(IPizzaDao dao, Scanner scan) {

		super(dao, scan);

	}

	public void execute() {

		int i;
		List<Pizza> p = dao.findAllPizzas() ;

		
		for (i = 0; i < p.size(); i++) {
			if (p.get(i) != null) {
				
				
				System.out.println(p.get(i).getId() + " " + p.get(i).getCode() + " " + p.get(i).getNom() + " "
						+(p.get(i).getPrix())+ " "+p.get(i).getCat());
				
			}
		}

	}

}
