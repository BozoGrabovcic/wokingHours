
package com.lab.software.engineering.project.workinghours.service;

import java.util.List;

import com.lab.software.engineering.project.workinghours.entity.Employee;
import com.lab.software.engineering.project.workinghours.entity.Job;
import com.lab.software.engineering.project.workinghours.entity.Jobhistory;

public interface EmployeeService {

	public List<Employee> getEmployee();

	public void saveEmployee(Employee theEmployee);
	
	Employee findByUsername(String username);

	public void updateEmployee(Employee theEmployee, long employeeid);
	
	public Employee getEmployee(long theId);

	public void deleteEmployee(long theId);

	public void changeEmployeeJob(Job job, long employeeid);
	
	public List<Employee> findBySearchTerm(String searchTerm);

	public List<Employee> findByActive();
	
//	public List<Workingday> getWorkingDaysByEmployeeID(long employeeid);
	
	public List<Jobhistory> getJobhistoryByEmployeeID(long employeeid);
	
	public List<?> getEmployeesAndTheirJobs();
//	 public  List<Employee> employeeWithWorkingday();
//	
}