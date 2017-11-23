package org.app.service.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Task implements Serializable{
	
	@Id @GeneratedValue
	private Integer task_id;
	
	@ManyToOne
	private Employee employee;
	
	@ManyToOne
	private Requirement requirement;

	public Integer getTask_id() {
		return task_id;
	}

	public void setTask_id(Integer task_id) {
		this.task_id = task_id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Requirement getRequirement() {
		return requirement;
	}

	public void setRequirement(Requirement requirement) {
		this.requirement = requirement;
	}

	public Task(Integer task_id) {
		super();
		this.task_id = task_id;
	}

	public Task() {
		super();
	}

	public Task(Integer task_id, Employee employee) {
		super();
		this.task_id = task_id;
		this.employee = employee;
	}
	
}
