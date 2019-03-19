package com.lab.software.engineering.project.workinghours.service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lab.software.engineering.project.workinghours.dao.EmployeeRepository;
import com.lab.software.engineering.project.workinghours.dao.EmployeeRepositoryCustom;
import com.lab.software.engineering.project.workinghours.dao.JobHistoryRepository;
import com.lab.software.engineering.project.workinghours.dao.RoleRepository;
import com.lab.software.engineering.project.workinghours.entity.Employee;
import com.lab.software.engineering.project.workinghours.entity.Job;
import com.lab.software.engineering.project.workinghours.entity.Jobhistory;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	// need to inject Employee dao
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private EmployeeRepositoryCustom employeeRepositoryCustom;
	
	@Autowired
	private JobHistoryRepository jobhistoryRepository;
	
	 @Autowired
	 private RoleRepository roleRepository;
	
	 @Autowired
	 private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	@Transactional
	public List<Employee> getEmployee() {
		return employeeRepository.findAll(new Sort(Sort.Direction.ASC, "employeeid"));
	}

	@Override
	public void saveEmployee(Employee theEmployee) {
		System.out.println("Save Employee");
		Job job = theEmployee.getJob();
//		System.out.println(job);
		theEmployee.setPassword(bCryptPasswordEncoder.encode(theEmployee.getPassword()));
		theEmployee.setRoles(new HashSet<>(roleRepository.findAll()));
		employeeRepository.save(theEmployee);
		Employee employee = employeeRepository.findByUsername(theEmployee.getUsername());
//		System.out.println(employee);
		Jobhistory jobHistory = new Jobhistory();
		jobHistory.setJob(job);
		jobHistory.setStartdate(theEmployee.getHiredate());
		jobHistory.setEmployee(employee);
//		System.out.println(jobHistory);
		
		jobhistoryRepository.save(jobHistory);
	}
	
	@Override

	public Employee getEmployee(long theId) {
		
		Optional<Employee> result= employeeRepository.findById(theId);
		Employee theEmployee=null;
		if(result.isPresent()) {
			theEmployee=result.get();
		}else {
			throw new RuntimeException("Did not find employee id: "+theId);
		}
		return theEmployee;
	}

	@Override

	public void deleteEmployee(long theId) {
		
		employeeRepository.deleteById(theId);
	}

	@Override
	public List<Employee> findBySearchTerm(String searchTerm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> findByActive() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	@Transactional
	public List<?> getEmployeesAndTheirJobs() {
		// TODO Auto-generated method stub
		return employeeRepositoryCustom.getEmployeesAndTheirJobs();
	}

//	@Override
//	@Transactional
//	public List<Workingday> getWorkingDaysByEmployeeID(long employeeid) {
//		// TODO Auto-generated method stub
////		return employeeRepositoryCustom.getWorkingDaysByEmployeeID(employeeid);
//		return null;
//	}

	@Override
	@Transactional
	public List<Jobhistory> getJobhistoryByEmployeeID(long employeeid) {
		// TODO Auto-generated method stub
		return employeeRepositoryCustom.getJobhistoryByEmployeeID(employeeid);
	}

	@Override
	public void changeEmployeeJob(Job job, long employeeid) {
		// TODO Auto-generated method stub
		Optional<Employee> result= employeeRepository.findById(employeeid);
		Employee theEmployee=null;
		if(result.isPresent()) {
			theEmployee=result.get();
			List<Jobhistory> jobhistories = theEmployee.getJobhistories();
			Jobhistory jobhistory = null;
			for(Jobhistory jh: jobhistories) {
				if((jh.getEmployeeId() == theEmployee.getEmployeeid()) && (jh.getJob().getJobid() == theEmployee.getJob().getJobid())&& (jh.getEnddate()==null)) {
					jobhistory = jh;
					
					Date date = new Date();
					System.out.println(date);
					jobhistory.setEnddate(date);
					jobhistoryRepository.save(jobhistory);
					
					Jobhistory jobHistory = new Jobhistory();
					jobHistory.setJob(job);
					jobHistory.setStartdate(date);
					jobHistory.setEmployee(theEmployee);
					jobhistoryRepository.save(jobHistory);
					theEmployee.setJob(job);
					employeeRepository.save(theEmployee);
				}
			}
		}else {
			throw new RuntimeException("Did not find employee id: "+employeeid);
		}
		
		
	}

	@Override
	public void updateEmployee(Employee employee, long employeeid) {
		// TODO Auto-generated method stub
		
		Optional<Employee> result= employeeRepository.findById(employeeid);
		Employee theEmployee=null;
		if(result.isPresent()) {
			theEmployee=result.get();
			
			theEmployee.setFirstname(employee.getFirstname());
			theEmployee.setLastname(employee.getLastname());
			theEmployee.setPassword(employee.getPassword());
			employeeRepository.save(theEmployee);
			
		}else {
			throw new RuntimeException("Did not find employee id: "+employeeid);
		}
		
	}

	@Override
	public Employee findByUsername(String username) {
		 return employeeRepository.findByUsername(username);
	}

//	@Override
//	public List<Employee> findBySearchTerm(String searchTerm) {
//		return employeeRepository.findBySearchTerm(searchTerm);
//	}
//
//	@Override
//	public List<Employee> findByActive() {
//		return employeeRepository.findByActive();
//	}

//	@Override
//	public List<Employee> employeeWithWorkingday() {
//		return employeeRepository.employeeWithWorkingday();
//	}
}





