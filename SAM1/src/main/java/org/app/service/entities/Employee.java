package org.app.service.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import static javax.persistence.CascadeType.ALL;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "entityType", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("regular_employee")
public class Employee implements Serializable{

	@Id @GeneratedValue
	private Integer employee_id;
	private String first_name;
	private String last_name;
	@Temporal(TemporalType.DATE)
	private Date date_of_birth;
	private String address;
	@OneToMany(mappedBy = "employee", cascade = ALL)
	private List<Task> tasks;
	
	@ManyToOne
	private Team team;
	public Integer getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(Integer employee_id) {
		this.employee_id = employee_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public Date getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(Integer employee_id, String first_name, String last_name, Date date_of_birth, String address) {
		super();
		this.employee_id = employee_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.date_of_birth = date_of_birth;
		this.address = address;
	}
	public List<Task> getTasks() {
		return tasks;
	}
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	public Employee(Integer employee_id, String first_name, String last_name, Date date_of_birth, String address,
			List<Task> tasks) {
		super();
		this.employee_id = employee_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.date_of_birth = date_of_birth;
		this.address = address;
		this.tasks = tasks;
	}
	
	
	
	
}
