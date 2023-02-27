package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.InventoryReport;

/**
 * @author Bradh 
 * CIS175 23290 Java II Spring 2023
 * Feb 26, 2023
 */

public class InventoryReportHelper {
	
	static EntityManagerFactory emfac = Persistence.createEntityManagerFactory("CarDealership");

	public void insertNewListDetails(InventoryReport rep) {
		EntityManager em = emfac.createEntityManager();
		em.getTransaction().begin();
		em.persist(rep);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<InventoryReport> getLists() {
		EntityManager em = emfac.createEntityManager();
		List<InventoryReport> allDetails = em.createQuery("Select rep From InventoryReport d").getResultList();
		return allDetails;
	}
	
	public void deleteList(InventoryReport listToDelete) {
		EntityManager em = emfac.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<InventoryReport> typedQuery = em.createQuery("select detail from InventoryReprort detail where detail.id = :selectedId", InventoryReport.class);
		
		// Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedId", listToDelete.getId());
		
		// we only want one result
		typedQuery.setMaxResults(1);
		
		// get the result and save it into a new list item
		InventoryReport result = typedQuery.getSingleResult();
		
		// remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public InventoryReport searchForListDetailsById(Integer tempId) {
			// TODO Auto-generated method stub
			EntityManager em = emfac.createEntityManager();
			em.getTransaction().begin();
			InventoryReport found = em.find(InventoryReport.class, tempId);
			em.close();
			return found;
		}	
	
	public void updateReport(InventoryReport reportToUpdate) {
		// TODO Auto-generated method stub
		EntityManager em = emfac.createEntityManager();
		em.getTransaction().begin();
		em.merge(reportToUpdate);
		em.getTransaction().commit();
		em.close();
	}
}
