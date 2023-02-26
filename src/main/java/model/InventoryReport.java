package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


/**
 * @author Bradh 
 * CIS175 23290 Java II Spring 2023
 * Feb 26, 2023
 */

@Entity
public class InventoryReport {
	
	@Id
	@GeneratedValue
	private int id;
	private String inventoryTitle;
	private LocalDate inventoryDate;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private CarDealers carDealer;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<CarDealers>listOfCars;
	
	public InventoryReport() {
		super();
	}
	
	public InventoryReport(String inventoryTitle, LocalDate inventoryDate, CarDealers carDealer) {
		super();
		this.inventoryTitle = inventoryTitle;
		this.inventoryDate = inventoryDate;
		this.carDealer = carDealer;
	}
	
	public InventoryReport(String inventoryTitle, LocalDate inventoryDate, CarDealers carDealer,
			List<CarDealers> listOfCars) {
		super();
		this.inventoryTitle = inventoryTitle;
		this.inventoryDate = inventoryDate;
		this.carDealer = carDealer;
		this.listOfCars = listOfCars;
	}
	
	public InventoryReport(int id, String inventoryTitle, LocalDate inventoryDate, CarDealers carDealer,
			List<CarDealers> listOfCars) {
		super();
		this.id = id;
		this.inventoryTitle = inventoryTitle;
		this.inventoryDate = inventoryDate;
		this.carDealer = carDealer;
		this.listOfCars = listOfCars;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getInventoryTitle() {
		return inventoryTitle;
	}
	public void setInventoryTitle(String inventoryTitle) {
		this.inventoryTitle = inventoryTitle;
	}
	public LocalDate getInventoryDate() {
		return inventoryDate;
	}
	public void setInventoryDate(LocalDate inventoryDate) {
		this.inventoryDate = inventoryDate;
	}
	public CarDealers getCarDealer() {
		return carDealer;
	}
	public void setCarDealer(CarDealers carDealer) {
		this.carDealer = carDealer;
	}
	public List<CarDealers> getListOfCars() {
		return listOfCars;
	}
	public void setListOfCars(List<CarDealers> listOfCars) {
		this.listOfCars = listOfCars;
	}

	@Override
	public String toString() {
		return "InventoryReport [id=" + id + ", inventoryTitle=" + inventoryTitle + ", inventoryDate=" + inventoryDate
				+ ", carDealer=" + carDealer + ", listOfCars=" + listOfCars + "]";
	}
	
}
