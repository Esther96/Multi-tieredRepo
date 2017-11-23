package org.app.service.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Team {

	@Id @GeneratedValue
	private Integer team_id;
	private String team_name;
	
	@OneToMany(mappedBy = "team")
	private List<Employee> employees = new ArrayList<>();
	
	@ManyToOne
	private Team_manager manager;

	public Integer getTeam_id() {
		return team_id;
	}

	public void setTeam_id(Integer team_id) {
		this.team_id = team_id;
	}

	public String getTeam_name() {
		return team_name;
	}

	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Team_manager getManager() {
		return manager;
	}

	public void setManager(Team_manager manager) {
		this.manager = manager;
	}
	
}
