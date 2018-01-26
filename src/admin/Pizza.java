package admin;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import admin.CategoriePizza;


@Entity
@Table(name="pizzas")
public class Pizza {

	/**
	 * ID de la pizza
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer ID;
	/**
	 * code de la pizza
	 */
	@Column(name="code",length=4, nullable=false, unique=true)
	private String code;
	/**
	 * nom de la pizza
	 */
	@Column(name="nom", length=30, nullable=false)
	private String nom;
	/**
	 * prix de la pizza
	 */
	@Column(name="prix", nullable=false)
	private double prix;

	/**
	 * Catégorie de la pizza
	 */
	@Column(name="cat", nullable=false)
	@Enumerated(EnumType.STRING)
	private CategoriePizza cat;
	
	@Transient
	BigDecimal price;
	@Transient
	Pizza p;

	static int compteur = 1;

	public Pizza() {

	}


	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}


	/**
	 * @param price the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}


	/**
	 * @return the p
	 */
	public Pizza getP() {
		return p;
	}


	/**
	 * @param p the p to set
	 */
	public void setP(Pizza p) {
		this.p = p;
	}


	/**
	 * @return the compteur
	 */
	public static int getCompteur() {
		return compteur;
	}


	/**
	 * @param compteur the compteur to set
	 */
	public static void setCompteur(int compteur) {
		Pizza.compteur = compteur;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.ID = id;
	}


	public Pizza(String code, String nom, double prix, CategoriePizza cat) {

	
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.cat = cat;

	}

	public Pizza(Integer id, String code, String name, BigDecimal price, CategoriePizza cat) {

		this.ID = id;
		this.code = code;
		this.nom = name;
		this.price = price;
		this.cat = cat;
	}

	public Pizza(Pizza pizza) {
		// TODO Auto-generated constructor stub
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
		return this.ID;
	}


	public void add(Pizza pizza) {
		// TODO Auto-generated method stub
		
	}

}
