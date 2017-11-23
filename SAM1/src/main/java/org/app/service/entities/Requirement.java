package org.app.service.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Requirement {

	@Id @GeneratedValue
	private Integer requirement_id;
	private String description;
	
	@OneToMany(mappedBy = "requirement")
	private List<Task> tasks = new ArrayList<>();
	
	@ManyToOne
	private Team_manager manager;
	
	@OneToMany(mappedBy = "requirement")
	private List<FeedbackProgress> progresses = new ArrayList<>();

	public Integer getRequirement_id() {
		return requirement_id;
	}

	public void setRequirement_id(Integer requirement_id) {
		this.requirement_id = requirement_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public Team_manager getManager() {
		return manager;
	}

	public void setManager(Team_manager manager) {
		this.manager = manager;
	}

	public List<FeedbackProgress> getProgresses() {
		return progresses;
	}

	public void setProgresses(List<FeedbackProgress> progresses) {
		this.progresses = progresses;
	}
	
}
