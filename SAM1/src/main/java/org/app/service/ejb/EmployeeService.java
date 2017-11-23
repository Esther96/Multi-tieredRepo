package org.app.service.ejb;

import java.util.Collection;

import javax.ejb.Remote;

import org.app.service.entities.*;

@Remote
public interface EmployeeService {

	Employee addEmployee(Employee employeeToAdd);
	
	String removeEmployee(Employee employeeToRemove);
	
	Employee getEployeeById(Integer Id);
	Collection<Employee> getEmployees();
	
	String sayRest();
	
	
}
