package org.app.service.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@SecondaryTable(name = "Team_manager")
public class Team_manager extends Employee {
	
	@OneToMany(mappedBy = "manager")
	private List<Team> teams = new ArrayList<>();
	
	@OneToMany(mappedBy = "manager")
	private List<Requirement> requirements  = new ArrayList<>();

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	public List<Requirement> getRequirements() {
		return requirements;
	}

	public void setRequirements(List<Requirement> requirements) {
		this.requirements = requirements;
	}
	
	
}
