package org.app.service.ejb;

import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.app.service.entities.Task;

@Stateless @LocalBean
public class TaskServiceEJB implements TaskService{

private static Logger logger = Logger.getLogger(TaskServiceEJB.class.getName());
	
	@PersistenceContext(unitName="MSD")
	private EntityManager em;
	
	public TaskServiceEJB()
	{
		
	}
	@PostConstruct
	public void init(){
		logger.info("Initialized :");		
	}
	
	@Override
	public Task addTask(Task taskToAdd) {
		// TODO Auto-generated method stub
		em.persist(taskToAdd);
		em.flush();
		em.refresh(taskToAdd);
		return taskToAdd;
	}

	@Override
	public String removeTask(Task TaskToRemove) {
		// TODO Auto-generated method stub
		TaskToRemove = em.merge(TaskToRemove);
		em.remove(TaskToRemove);
		em.flush();
		return "True";
	}

	@Override
	public Task getTaskById(Integer Id) {
		// TODO Auto-generated method stub
		return em.find(Task.class, Id);
	}

	@Override
	public Collection<Task> getTasks() {
		// TODO Auto-generated method stub
		List<Task> tasks = em.createQuery("SELECT t FROM Task t", Task.class).getResultList();
		return tasks;
	}

	@Override
	public String sayRest() {
		// TODO Auto-generated method stub
		return "Task service is on...";
	}

	

}
