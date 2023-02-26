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
@Table(name="Car Dealers")
public class CarDealers {
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="DEALER_NAME")
	private String dealerName;
	
	public CarDealers() {
		super();
	}
	
	public CarDealers(String dealerName) {
		super();
		this.dealerName = dealerName;
	}
	
	public CarDealers(int id, String dealerName) {
		super();
		this.id = id;
		this.dealerName = dealerName;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDealerName() {
		return dealerName;
	}
	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}

}
