package org.app.service.ejb.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.logging.Logger;

import javax.ejb.EJB;

import org.app.service.ejb.TaskService;
import org.app.service.ejb.TaskServiceEJB;
import org.app.service.entities.Task;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

@RunWith(Arquillian.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestTaskDataServiceEJBArq {
	private static Logger logger = Logger.getLogger(TestTaskDataServiceEJBArq.class.getName());
	
	@EJB
	private static TaskService service;
	
	@Deployment
	public static Archive<?> createDeployment() {
	        return ShrinkWrap
	        		.create(WebArchive.class, "SAM1.war")
	        		.addPackage(Task.class.getPackage())
	        		.addClass(TaskService.class)
	        		.addClass(TaskServiceEJB.class)
	        		.addAsResource("META-INF/persistence.xml")
	                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}
	@Test
	public void test1_GetMessage() {
		logger.info("DEBUG: Junit TESTING ...");
		String response = service.sayRest();
		assertNotNull("Data Service failed!", response);
		logger.info("DEBUG: EJB Response ..." + response);
	}
	
	@Test
	public void test4_GetTasks() {
		logger.info("DEBUG: JUnit TESTING: getEmployees....");
		Collection<Task> tasks = service.getTasks();
		assertTrue("Fail to read employees!", tasks.size()>0);
	
	}
	
	@Test
	public void test3_AddTask() {
		logger.info("DEBUG: JUnit TESTING: addEmployee....");
		Integer tasksToAdd = 3;
		for(int i =1;i<=tasksToAdd;i++) {
			service.addTask(new Task(null));
		}
		Collection<Task> tasks = service.getTasks();
		assertTrue("Fail to add employees" , tasks.size()>=tasksToAdd);
		
	}
	
	

}
