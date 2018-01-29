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
@Table(name = "pizzas")
public class Pizza {

	/**
	 * ID de la pizza
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer ID;
	/**
	 * code de la pizza
	 */
	@Column(name = "code", length = 4, nullable = false, unique = true)
	private String code;
	/**
	 * nom de la pizza
	 */
	@Column(name = "nom", length = 30, nullable = false)
	private String nom;
	/**
	 * prix de la pizza
	 */
	@Column(name = "prix", nullable = false)
	private double prix;

	/**
	 * Catégorie de la pizza
	 * 
	 * + definition de la table pour JPA
	 */
	@Column(name = "cat", nullable = false)
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
	 * @param price
	 *            the price to set
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
	 * @param p
	 *            the p to set
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
	 * @param compteur
	 *            the compteur to set
	 */
	public static void setCompteur(int compteur) {
		Pizza.compteur = compteur;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.ID = id;
	}

	/**
	 * Constructeur pizza Dao
	 * 
	 * @param code
	 * @param nom
	 * @param prix
	 * @param cat
	 */
	public Pizza(String code, String nom, double prix, CategoriePizza cat) {

		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.cat = cat;

	}

	/**
	 * Constructeur pizza Dao
	 * 
	 * @param id
	 * @param code
	 * @param name
	 * @param price
	 * @param cat
	 */
	public Pizza(Integer id, String code, String name, BigDecimal price, CategoriePizza cat) {

		this.ID = id;
		this.code = code;
		this.nom = name;
		this.price = price;
		this.cat = cat;
	}

	/**
	 * Constucteur par defaut JPA
	 * 
	 * @param pizza
	 */
	public Pizza(Pizza pizza) {
		// TODO Auto-generated constructor stub
	}

	/**
	 * retourne la categorie de pizza
	 * 
	 * @return cat
	 */
	public CategoriePizza getCat() {
		return cat;
	}

	/**
	 * prend en parametre la categorie et l'instancie
	 * 
	 * @param cat
	 */
	public void setCat(CategoriePizza cat) {
		this.cat = cat;
	}

	/**
	 * retourne le code de la pizza
	 * 
	 * @return
	 */
	public String getCode() {
		return code;
	}

	/**
	 * prend en parametre le code et l'instancie
	 * 
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * retourne la valeur du nom de la pizza
	 * 
	 * @return
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * prend en parametre le nom de la pizza et l'instancie
	 * 
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * retourne le prix de la pizza
	 * 
	 * @return
	 */
	public double getPrix() {
		return prix;
	}

	/**
	 * prend en parametre le prix de la pizza et l'instancie
	 * 
	 * @param prix
	 */
	public void setPrix(double prix) {
		this.prix = prix;
	}

	/**
	 * retourne l'id de la pizza
	 * @return
	 */
	public int getId() {
		return this.ID;
	}

	/**
	 * ajoute une pizza a la liste de pizza
	 * @param pizza
	 */
	public void add(Pizza pizza) {
		// TODO Auto-generated method stub

	}

}
