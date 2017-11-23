package org.app.service.ejb;

import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.app.service.entities.Employee;

@LocalBean @Stateless
public class EmployeeServiceEJB  implements EmployeeService{
	private static Logger logger = Logger.getLogger(EmployeeServiceEJB.class.getName());
	
	@PersistenceContext(unitName="MSD")
	private EntityManager em;
	
	public EmployeeServiceEJB() {
		
	}
	
	@PostConstruct
	public void init(){
		logger.info("Initialized :");		
	}

	@Override
	public Employee addEmployee(Employee employeeToAdd) {
		
		em.persist(employeeToAdd);
		em.flush();
		em.refresh(employeeToAdd);
		return employeeToAdd;
		
	}

	@Override
	public String removeEmployee(Employee employeeToRemove) {
		employeeToRemove = em.merge(employeeToRemove);
		em.remove(employeeToRemove);
		em.flush();
		return "True";
	}

	@Override
	public Employee getEployeeById(Integer Id) {
		return em.find(Employee.class, Id);
	}

	@Override
	public Collection<Employee> getEmployees() {
		List<Employee> employees = em.createQuery("SELECT e FROM Employee e",Employee.class).getResultList();
		return employees;
	}

	@Override
	public String sayRest() {
		return "Feature service is on...";
	}	
	
	
}
