package exeption;

public class SavePizzaExeption extends StockageException {

	/**
	 * exeption sur l'ajout d'une pizza
	 */
	private static final long serialVersionUID = 5822025730364128715L;

	public SavePizzaExeption(String message) {
		super(message);
	}

}