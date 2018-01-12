package admin;

import java.math.BigDecimal;

import admin.CategoriePizza;;

public class Pizza {

	String code;
	String nom;
	double prix;
	int id;
	CategoriePizza cat;
	BigDecimal price;

	static int compteur = 1;

	public Pizza() {

	}

	public Pizza(String code, String nom, double prix, CategoriePizza cat) {

		this.id = compteur++;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.cat = cat;

	}

	public Pizza(Integer id, String code, String name, BigDecimal price, CategoriePizza cat) {

		this.id = id;
		this.code = code;
		this.nom = name;
		this.price = price;
		this.cat = cat;
	}

	public CategoriePizza getCat() {
		return cat;
	}

	public void setCat(CategoriePizza cat) {
		this.cat = cat;
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
