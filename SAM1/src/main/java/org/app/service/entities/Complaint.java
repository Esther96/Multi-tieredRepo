package org.app.service.entities;

import javax.persistence.*;

@Entity
@SecondaryTable(name = "Complaint")
public class Complaint extends Feedback{
	
	@Column(table = "Complaint")
	private Complaint_type complaint_type;
	@Column(table = "Complaint")
	private String description;
	public Complaint_type getComplaint_type() {
		return complaint_type;
	}
	public void setComplaint_type(Complaint_type complaint_type) {
		this.complaint_type = complaint_type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
