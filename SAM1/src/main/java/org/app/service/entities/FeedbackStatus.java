package org.app.service.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class FeedbackStatus {

	@Id @GeneratedValue
	private Integer feedback_status_id;
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@OneToMany(mappedBy = "status")
	private List<FeedbackProgress> progresses = new ArrayList<>();
	
}
