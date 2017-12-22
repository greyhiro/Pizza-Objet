package admin;


	public enum CategoriePizza {

		VIANDE("Viande"), POISSON("Poisson"), SANS_VIANDE("Sans Viande");

		private String categoriePizza;

		private CategoriePizza(String categoriePizza) {

			this.categoriePizza = categoriePizza;
		}

		public String getcategoriePizza() {
			return categoriePizza;
		}
		
	
}
