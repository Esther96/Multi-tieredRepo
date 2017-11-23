package org.app.service.entities;

import javax.persistence.*;

@Entity
@SecondaryTable(name = "Improvement")
public class Improvement extends Feedback{

	private String description;
	private String improvement_type;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImprovement_type() {
		return improvement_type;
	}
	public void setImprovement_type(String improvement_type) {
		this.improvement_type = improvement_type;
	}
	
}
