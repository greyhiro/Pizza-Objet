package dao;

import javax.persistence.TypedQuery;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import admin.Pizza;

import java.util.List;

public class DaoJPA implements IPizzaDao {

	EntityManager em;

	/**
	 * Verifie que la pizza choisi existe bien en base
	 */
	@Override
	public boolean verifPizzaExiste(String code) {

		EntityManager em = connexion();

		TypedQuery<Pizza> query = em.createQuery("FROM Pizza", Pizza.class);
		for (int i = 0; i < query.getResultList().size(); i++) {

			Pizza pizza = (Pizza) query.getResultList().get(i);

			if (pizza.getCode().equals(code)) {
				System.out.println("la pizza existe");

				return true;

			}

		}
		return false;

	}

	/**
	 * liste pizza en base
	 */

	@Override
	public List<Pizza> findAllPizzas() {

		EntityManager em = connexion();

		EntityTransaction et = em.getTransaction();
		et.begin();

		TypedQuery<Pizza> query = em.createQuery("FROM Pizza", Pizza.class);

		List<Pizza> p = query.getResultList();

		et.commit();
		em.close();

		return p;

	}

	/**
	 * ajoute une pizza en base
	 */
	@Override
	public void saveNewPizza(Pizza pizza) {

		EntityManager em = connexion();
		EntityTransaction et = em.getTransaction();
		et.begin();

		em.persist(pizza);
		et.commit();

		em.close();
	}

	/**
	 * supprime une pizza en base
	 */

	@Override
	public boolean supprimerPizza(String pizzSupr) {

		EntityManager em = connexion();

		EntityTransaction et = em.getTransaction();

		et.begin();

		TypedQuery<Pizza> query = em.createQuery("FROM Pizza", Pizza.class);
		for (int i = 0; i < query.getResultList().size(); i++) {
			Pizza piz = (Pizza) query.getResultList().get(i);

			if (piz.getCode().equals(pizzSupr)) {

				System.out.println(piz.getCode());
				em.remove(piz);
				et.commit();
				em.close();
				return true;
			}

		}

		return false;

}

	/**
	 * Modifie la pizza en base
	 */

	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) {

		EntityManager em = connexion();
		EntityTransaction et = em.getTransaction();
		et.begin();


		TypedQuery<Pizza> query = em.createQuery("FROM Pizza", Pizza.class);
		for (int i = 0; i < query.getResultList().size(); i++) {
			Pizza piz = (Pizza) query.getResultList().get(i);


			if (verifPizzaExiste(codePizza) == true) {

				
				em.remove(piz);
				em.persist(pizza);
				et.commit();
				em.close();
				return true;
			}

		}

		return false;

	}

	/**
	 * Connexion a la BDD + creation de persistance
	 * 
	 * @return
	 */
	public EntityManager connexion() {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_pizza");
		EntityManager em = entityManagerFactory.createEntityManager();
		return em;

	}

}
