package org.app.service.ejb.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.Date;
import java.util.logging.Logger;

import javax.ejb.EJB;

import org.app.service.ejb.DataService;
import org.app.service.ejb.EmployeeService;
import org.app.service.ejb.EmployeeServiceEJB;
import org.app.service.entities.Employee;
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
public class TestEmployeeServiceEJBArq {
	
private static Logger logger = Logger.getLogger(TestEmployeeServiceEJBArq.class.getName());
	
	// Arquilian infrastructure
	@EJB
	private static EmployeeService service;
	
	@Deployment
	public static Archive<?> createDeployment() {
	        return ShrinkWrap
	        		.create(WebArchive.class)
	        		.addPackage(Employee.class.getPackage())
	        		.addClass(EmployeeService.class)
	        		.addClass(EmployeeServiceEJB.class)
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
	public void test4_GetEmployees() {
		logger.info("DEBUG: JUnit TESTING: getEmployees....");
		Collection<Employee> employees = service.getEmployees();
		assertTrue("Fail to read employees!", employees.size()>0);
	
	}
	
	@Test
	public void test3_AddEmployee() {
		logger.info("DEBUG: JUnit TESTING: addEmployee....");
		Integer employeesToAdd = 3;
		for(int i =1;i<=employeesToAdd;i++) {
			service.addEmployee(new Employee(null,"Estera","Maftei",null,"Strada mea"));
		}
		Collection<Employee> employees = service.getEmployees();
		assertTrue("Fail to add employees" , employees.size()>=3);
		
	}
	
}
	
