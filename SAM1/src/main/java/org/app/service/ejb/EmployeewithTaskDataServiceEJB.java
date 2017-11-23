package org.app.service.ejb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.app.patterns.EntityRepository;
import org.app.patterns.EntityRepositoryBase;
import org.app.service.entities.Employee;
import org.app.service.entities.Task;

@Stateless @LocalBean
public class EmployeewithTaskDataServiceEJB extends EntityRepositoryBase<Employee>
		implements EmployeeWithTaskDataService, Serializable {
	private static Logger logger = Logger.getLogger(EmployeewithTaskDataServiceEJB.class.getName());
	
	@EJB // injected DataService
	private TaskService taskDataService; 
	// Local component-entity-repository
	private EntityRepository<Task> taskRepository;
	@PostConstruct
	public void init() {
		// local instantiation of local component-entity-repository
		taskRepository = new EntityRepositoryBase<Task>(this.em,Task.class);
		logger.info("POSTCONSTRUCT-INIT releaseRepository: " + this.taskRepository);
		logger.info("POSTCONSTRUCT-INIT featureDataService: " + this.taskDataService);
	}
	
	// Aggregate factory method
	
	
	

	

	@Override
	public Employee createNewEmployee(Integer id) {
		// TODO Auto-generated method stub
		Employee employee = new Employee(id, "NEW name","new last name" , new Date(), "new address");
		List<Task> tasksEmployee = new ArrayList<>();
		//Date dataTask = new Date();
		//Long interval =  30l /*zile*/ * 24 /*ore*/ * 60 /*min*/ * 60 /*sec*/ * 1000 /*milisec*/;
		Integer tasksCount = 3;
		for (int i=0; i<=tasksCount-1; i++){
			tasksEmployee.add(new Task(null,employee));
		}
		employee.setTasks(tasksEmployee);		
		// save project aggregate
		this.add(employee);
		// return project aggregate to service client
		return employee;
	}

	@Override
	public Task getTaskById(Integer task_id) {
		// TODO Auto-generated method stub
		return taskRepository.getById(task_id);
	}
	public String getMessage() {
		return "ProjectSprint DataService is working...";
	}
	
	
	@Override
	public Employee addEmployee(Employee employeeToAdd) throws Exception {
		System.out.println("em = " + em);
			if(employeeToAdd.getEmployee_id() == null)
			{
				em.persist(employeeToAdd);
				em.flush();
				em.refresh(employeeToAdd);
			}
			else 
			{
				em.merge(employeeToAdd);
			}
			return employeeToAdd;
	}

	}


 
