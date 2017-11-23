package org.app.service.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Warranty {
	@Id @GeneratedValue
	int warranty_id;
	int license_key;
	String description;
	@Temporal(TemporalType.DATE)
	Date date_created;
	@ManyToOne
	private Customer customer;
	
	@OneToMany(mappedBy = "warranty_issue",fetch = FetchType.EAGER)
	private List<Warranty_issue> warranties_issue = new ArrayList<>();
	
	public List<Warranty_issue> getWarranties_issue() {
		return warranties_issue;
	}
	public void setWarranties_issue(List<Warranty_issue> warranties_issue) {
		this.warranties_issue = warranties_issue;
	}
	public int getWarranty_id() {
		return warranty_id;
		
	}
	public void setWarranty_id(int warranty_id) {
		this.warranty_id = warranty_id;
	}
	public int getLicense_key() {
		return license_key;
	}
	public void setLicense_key(int license_key) {
		this.license_key = license_key;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate_created() {
		return date_created;
	}
	public void setDate_created(Date date_created) {
		this.date_created = date_created;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
