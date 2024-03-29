package com.lab.software.engineering.project.workinghours.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab.software.engineering.project.workinghours.dao.EmployeeRepository;
import com.lab.software.engineering.project.workinghours.entity.Employee;
import com.lab.software.engineering.project.workinghours.entity.Job;
import com.lab.software.engineering.project.workinghours.entity.Jobhistory;
import com.lab.software.engineering.project.workinghours.service.EmployeeService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> getAll(){
		return employeeService.getEmployee();
		//return employeeService.getEmployeesAndTheirJobs();
	}
	
//	@GetMapping("/employees/{employeeid}")
//	public Optional<Employee> getEmployeeByID(@PathVariable long employeeid){
//		return employeeRepository.findById(employeeid);
//	}
	
	@GetMapping("/employees/{employeeid}")
	public Employee getEmployeeByID(@PathVariable long employeeid) {
		return employeeService.getEmployee(employeeid);
	}
	
//	@GetMapping("/employees/{employeeid}/workingdays")
//	public List<Workingday> getWorkingDaysByEmployeeID(@PathVariable long employeeid){
////		return employeeRepository.findById(employeeid);
//		return employeeService.getWorkingDaysByEmployeeID(employeeid);
//	}
	
	@PostMapping("/employees")
	public void createEmployee(@RequestBody Employee newEmployee){
		
		System.out.println(newEmployee);
		
		employeeService.saveEmployee(newEmployee);
	}
	
	@PutMapping("/employees/{employeeid}")
	public void updateEmployee(@RequestBody Employee newEmployee, @PathVariable long employeeid){
		
		System.out.println(newEmployee);
		
		employeeService.updateEmployee(newEmployee, employeeid);
	}
	
	@PutMapping("/employees/{employeeid}/job")
	public void changeEmployeeJob(@RequestBody Job job, @PathVariable long employeeid){
		
		
		employeeService.changeEmployeeJob(job, employeeid);
	}
	
//	@GetMapping("/employees/{employeeid}/jobhistories")
//	public List<Jobhistory> getJobhistoryByEmployeeID(@PathVariable long employeeid){
////		return employeeRepository.findById(employeeid);
//		return employeeService.getJobhistoryByEmployeeID(employeeid);
//	}
	

	
}
