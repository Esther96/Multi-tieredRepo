package org.app.service.entities;

import javax.persistence.*;

@Entity
public class FeedbackProgress {

	@Id @GeneratedValue
	private Integer feedback_progress_id;
	
	@ManyToOne
	private Requirement requirement;
	
	@ManyToOne
	private FeedbackStatus status;
	
	@ManyToOne
	private Feedback feedback;

	public Integer getFeedback_progress_id() {
		return feedback_progress_id;
	}

	public void setFeedback_progress_id(Integer feedback_progress_id) {
		this.feedback_progress_id = feedback_progress_id;
	}

	public Requirement getRequirement() {
		return requirement;
	}

	public void setRequirement(Requirement requirement) {
		this.requirement = requirement;
	}

	public FeedbackStatus getStatus() {
		return status;
	}

	public void setStatus(FeedbackStatus status) {
		this.status = status;
	}

	public Feedback getFeedback() {
		return feedback;
	}

	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}
	
}
