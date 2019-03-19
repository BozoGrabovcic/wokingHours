package com.lab.software.engineering.project.workinghours.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lab.software.engineering.project.workinghours.dao.EmployeeRepository;
import com.lab.software.engineering.project.workinghours.dao.JobRepository;
import com.lab.software.engineering.project.workinghours.dao.WorkingdayRepository;
import com.lab.software.engineering.project.workinghours.entity.Employee;
import com.lab.software.engineering.project.workinghours.entity.Job;
import com.lab.software.engineering.project.workinghours.entity.Workingday;


@Service
public class JobServiceImpl implements JobService {

//	// need to inject Employee dao
	@Autowired
	private JobRepository jobRepository;


	@Override
	
	public void saveJob(Job job) {

		jobRepository.save(job);
	}
	
	@Override
	
	public List<Job> getAll() {

		return jobRepository.findAll();
	}
//
//	@Override
//
//	public Employee getEmployee(long theId) {
//		
//		Optional<Employee> result= employeeRepository.findById(theId);
//		Employee theEmployee=null;
//		if(result.isPresent()) {
//			theEmployee=result.get();
//		}else {
//			throw new RuntimeException("Did not find employee id: "+theId);
//		}
//		return theEmployee;
//	}
//
//	@Override
//
//	public void deleteEmployee(long theId) {
//		
//		employeeRepository.deleteById(theId);
//	}
//
//	@Override
//	public List<Employee> findBySearchTerm(String searchTerm) {
//		return employeeRepository.findBySearchTerm(searchTerm);
//	}
//
//	@Override
//	public List<Employee> findByActive() {
//		return employeeRepository.findByActive();
//	}
//
//	@Override
//	public List<Workingday> employeeWithWorkingday() {
//		return wr.employeeWithWorkingday();
//	}
}





