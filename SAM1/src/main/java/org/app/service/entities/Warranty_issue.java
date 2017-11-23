package org.app.service.entities;

import javax.persistence.*;

@Entity
public class Warranty_issue {
	
	@Id @GeneratedValue
	private Integer Issue_Id;
	private String change_description;
	private boolean updated;
	@ManyToOne
	private Warranty warranty_issue;
	@ManyToOne
	private Consultant consultant;
	
	public Integer getIssue_Id() {
		return Issue_Id;
	}
	public void setIssue_Id(Integer issue_Id) {
		Issue_Id = issue_Id;
	}
	public String getChange_description() {
		return change_description;
	}
	public void setChange_description(String change_description) {
		this.change_description = change_description;
	}
	public boolean isUpdated() {
		return updated;
	}
	public void setUpdated(boolean updated) {
		this.updated = updated;
	}
	public Warranty getWarranty_issue() {
		return warranty_issue;
	}
	public void setWarranty_issue(Warranty warranty_issue) {
		this.warranty_issue = warranty_issue;
	}
	

}
