package org.app.service.ejb;

import java.util.Date;

import javax.ejb.Remote;

import org.app.patterns.EntityRepository;
import org.app.service.entities.Employee;
import org.app.service.entities.Task;
@Remote
public interface EmployeeWithTaskDataService extends EntityRepository<Employee>{
	Employee createNewEmployee(Integer id);
	
	Task getTaskById(Integer task_id);
	
	String getMessage();
	Employee addEmployee(Employee employeeToAdd) throws Exception;
	
	

}
