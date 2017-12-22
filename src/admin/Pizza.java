package admin;

public class Pizza {

	
	
	String code;
	String nom;
	double prix;
	int id;
	

	static int compteur = 1;

	public Pizza() {

	}

	public Pizza(String code, String nom, double prix) {

		this.id = compteur++;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		
		
		

	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getId() {
		return this.id;
	}


	


	
	

}
