package org.app.service.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Customer {
	@Id @GeneratedValue
	private Integer customer_id;
	private String name;
	private String address;
	
	@OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
	private List<Warranty> warranties = new ArrayList<>();
	
	@OneToMany(mappedBy = "customer")
	private List<Feedback> feedbacks = new ArrayList<>();
	
	public Integer getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Warranty> getWarranties() {
		return warranties;
	}

	public void setWarranties(List<Warranty> warranties) {
		this.warranties = warranties;
	}
	
}
