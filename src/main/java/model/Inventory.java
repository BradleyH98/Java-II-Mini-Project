package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Bradh 
 * CIS175 23290 Java II Spring 2023
 * Feb 26, 2023
 */

@Entity
@Table(name="Inventory")
public class Inventory {

	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="VEHICLE_MODEL")
	private String vehicleModel;
	@Column(name="VEHICLE_YEAR")
	private String vehicleYear;
	@Column(name="PRICE")
	private String price;
	
	public Inventory() {
		super();
	}
	
	public Inventory(String vehicleModel, String vehicleYear, String price) {
		super();
		this.vehicleModel = vehicleModel;
		this.vehicleYear = vehicleYear;
		this.price = price;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVehicleModel() {
		return vehicleModel;
	}
	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}
	public String getVehicleYear() {
		return vehicleYear;
	}
	public void setVehicleYear(String vehicleYear) {
		this.vehicleYear = vehicleYear;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Inventory [id=" + id + ", vehicleModel=" + vehicleModel + ", vehicleYear=" + vehicleYear + ", price="
				+ price + "]";
	}
	
	

}
