package org.app.service.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@SecondaryTable(name = "Consultant")
public class Consultant extends Employee
{
	@Column(table = "Consultant")
	private boolean update_warranty;
	@OneToMany(mappedBy = "consultant")
	private List<Warranty_issue> warranties_consultant = new ArrayList<>();
	public boolean isUpdate_warranty() {
		return update_warranty;
	}
	public void setUpdate_warranty(boolean update_warranty) {
		this.update_warranty = update_warranty;
	}
	public List<Warranty_issue> getWarranties_consultant() {
		return warranties_consultant;
	}
	public void setWarranties_consultant(List<Warranty_issue> warranties_consultant) {
		this.warranties_consultant = warranties_consultant;
	}
	
	
}
