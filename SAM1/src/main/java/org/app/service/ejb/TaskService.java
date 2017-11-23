package org.app.service.ejb;

import java.util.Collection;

import javax.ejb.Remote;

import org.app.service.entities.Task;

@Remote
	public interface TaskService {
		Task addTask(Task taskToAdd);
		
		String removeTask(Task TaskToRemove);
		
		Task getTaskById(Integer Id);
		Collection<Task> getTasks();
		
		String sayRest();

	}



