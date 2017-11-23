package org.app.service.entities;

import javax.persistence.*;

@Entity(name = "ChangeRequest")
public class ChangeRequest extends Feedback{
	
	private String feature;

	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}
	
}
