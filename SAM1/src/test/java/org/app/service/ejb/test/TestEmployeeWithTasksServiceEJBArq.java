package org.app.service.ejb.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;

import org.app.patterns.EntityRepository;
import org.app.service.ejb.EmployeeWithTaskDataService;
import org.app.service.ejb.EmployeewithTaskDataServiceEJB;
import org.app.service.ejb.TaskService;
import org.app.service.ejb.TaskServiceEJB;
import org.app.service.entities.Employee;
import org.app.service.entities.Task;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.jboss.shrinkwrap.api.spec.WebArchive;

@RunWith(Arquillian.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestEmployeeWithTasksServiceEJBArq  {
	private static Logger logger = Logger.getLogger(TestEmployeeWithTasksServiceEJBArq.class.getName());
	// Arquilian infrastructure
	@Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap
                .create(WebArchive.class)
                .addPackage(EntityRepository.class.getPackage()).addPackage(Employee.class.getPackage())
                .addClass(TaskService.class).addClass(TaskServiceEJB.class)
                .addClass(EmployeeWithTaskDataService.class).addClass(EmployeewithTaskDataServiceEJB.class)
                .addAsResource("META-INF/persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }
	@EJB // Test EJB Data Service Reference is injected
	private static EmployeeWithTaskDataService service;	
	// JUnit test methods
	//@Test
	public void test4_GetEmployee() {
		logger.info("DEBUG: Junit TESTING: testGetProject 7002 ...");
		Employee employee = service.getById(7002);
		assertNotNull("Fail to Get Project 7002!", employee);
	}
	/* CREATE Test 2: create aggregate*/
	//@Test
	public void test3_CreateNewEmployee(){
		Employee employee = service.createNewEmployee(7003);
		assertNotNull("Fail to create new project in repository!", employee);
		// update project
		employee.setFirst_name(employee.getFirst_name() + " - changed by test client");		
		List <Task> tasks = employee.getTasks();
		for(Task t: tasks)
			t.setTask_id(t.getTask_id());
		employee = service.add(employee);
		assertNotNull("Fail to save new project in repository!", employee);
		logger.info("DEBUG createNewProject: project changed: " + employee);
		// check read
		employee = service.getById(7002);  // !!!
		assertNotNull("Fail to find changed project in repository!", employee);
		logger.info("DEBUG createNewProject: queried project" + employee);
	}		

	//@Test
	public void test2_DeleteEmployee() {
		logger.info("DEBUG: Junit TESTING: testDeleteProject 7002...");
		Employee employee = service.getById(7003);  // !!!
		if (employee != null)
			service.remove(employee);
		employee = service.getById(7003);  // !!!
		assertNull("Fail to delete Project 7002!", employee);
	}	
	@Test
	public void test1_GetMessage() {
		logger.info("DEBUG: Junit TESTING: testGetMessage ...");
		String response = service.getMessage();
		assertNotNull("Data Service failed!", response);
		logger.info("DEBUG: EJB Response ..." + response);
	}	
	
	
	
	@Test
	public void test7_addEmployeeAndTasks() throws Exception {
		logger.info("DEBUG: Junit TESTING: addCompanyAndMessages...");
		
		Employee employee = service.addEmployee(new Employee(null,"Gabriela","Ciocoiu",new Date(),"Strada mea"));
		Integer nrtasks = 5;
		List<Task> listTasks = new ArrayList<Task>();
		for(int i=1;i<=nrtasks;i++)
		{
			listTasks.add(new Task(null,employee));
		}
		employee.setTasks(listTasks);
		//employee.setDescription("asdas");
		employee = service.addEmployee(employee);
		
		assertTrue("Fail to add Employee and tasks",employee.getTasks().size()!=0);
	}

}

