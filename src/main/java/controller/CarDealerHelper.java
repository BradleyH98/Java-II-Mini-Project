package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.CarDealers;

/**
 * @author Bradh 
 * CIS175 23290 Java II Spring 2023
 * Feb 26, 2023
 */

public class CarDealerHelper {
	
	static EntityManagerFactory emfac = Persistence.createEntityManagerFactory("CarDealership");

	public void insertCarDealer(CarDealers rep) {
		EntityManager em = emfac.createEntityManager();
		em.getTransaction().begin();
		em.persist(rep);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<CarDealers>showAllCarDealers() {
		EntityManager em = emfac.createEntityManager();
		List<CarDealers>allCarDealers = em.createQuery("Select rep From CarDealers rep").getResultList();
		return allCarDealers;
	}
	
	public CarDealers findCarDealers(String dealerName) {
		EntityManager em = emfac.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<CarDealers>typedQuery = em.createQuery("Select rep from CarDealers rep where rep.dealerName = :selectedName", CarDealers.class);
		
		typedQuery.setParameter("selectedName", dealerName);
		CarDealers foundDealers;
		try {
			foundDealers = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
			foundDealers = new CarDealers(dealerName);
		}
		em.close();
		return foundDealers;
	}
}
