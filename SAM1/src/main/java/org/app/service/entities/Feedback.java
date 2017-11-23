package org.app.service.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "entityType", discriminatorType = DiscriminatorType.STRING)
public class Feedback {

	@Id @GeneratedValue
	private Integer feedback_id;
	
	@ManyToOne
	private Customer customer;
	
	@Temporal(TemporalType.DATE)
	private Date date_of_registration;
	
	@OneToMany(mappedBy = "feedback")
	private List<FeedbackProgress> progresses = new ArrayList<>();
	
}
