package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Inventory;

/**
 * @author Bradh 
 * CIS175 23290 Java II Spring 2023
 * Feb 26, 2023
 */

public class InventoryHelper {
	
	static EntityManagerFactory emfac = Persistence.createEntityManagerFactory("Inventory");

	public void insertItem(Inventory rep) {
		EntityManager em = emfac.createEntityManager();
		em.getTransaction().begin();
		em.persist(rep);
		em.getTransaction().commit();
		em.close();
	}
	
	public void deleteItem(Inventory toDelete) {
		EntityManager em = emfac.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Inventory> typeQuery = em.createQuery(
				"select rep from Inventory rep where rep.vehicleModel = :selectedModel and rep.vehicleYear = :selectedYear and rep.price = :selectedPrice",
				Inventory.class);
		typeQuery.setParameter("selectedModel", toDelete.getVehicleModel());
		typeQuery.setParameter("selectedYear", toDelete.getVehicleYear());
		typeQuery.setParameter("selectedPrice", toDelete.getPrice());

		typeQuery.setMaxResults(1);

		Inventory result = typeQuery.getSingleResult();

		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Inventory>showAllItems() {
		EntityManager em = emfac.createEntityManager();
		List<Inventory> allItems = em.createQuery("select i from Inventory i").getResultList();
		return allItems;
	}
	
	public List<Inventory>searchByVehicleModel(String vehicleModel) {
		EntityManager em = emfac.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Inventory> typedQuery = em.createQuery(
				"select rep from Inventory rep where rep.vehicleModel = :selectedModel",
				Inventory.class);
		typedQuery.setParameter("selectedModel", vehicleModel);
		List<Inventory> foundItem = typedQuery.getResultList();
		em.close();
		
		return foundItem;
	}
	
	public List<Inventory>searchByVehicleYear(String vehicleYear) {
		EntityManager em = emfac.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Inventory> typedQuery = em.createQuery(
				"select rep from Inventory rep where rep.vehicleYear = :selectedYear",
				Inventory.class);
		typedQuery.setParameter("selectedYear", vehicleYear);
		List<Inventory> foundItem = typedQuery.getResultList();
		em.close();
		
		return foundItem;
	}
	
	public List<Inventory>searchByVehiclePrice(int vehiclePrice) {
		EntityManager em = emfac.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Inventory> typedQuery = em.createQuery(
				"select rep from Inventory rep where rep.vehiclePrice = :selectedPrice",
				Inventory.class);
		typedQuery.setParameter("selectedPrice", vehiclePrice);
		List<Inventory> foundItem = typedQuery.getResultList();
		em.close();
		
		return foundItem;
	}
	
	public Inventory searchForItembyId(int idToEdit) {
		EntityManager em = emfac.createEntityManager();
		em.getTransaction().begin();
		Inventory found = em.find(Inventory.class, idToEdit);
		em.close();
		return found;
	}
	
	public void updateItem(Inventory toEdit) {
		EntityManager em = emfac.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public void cleanUp() {
		emfac.close();
	}
	
}
