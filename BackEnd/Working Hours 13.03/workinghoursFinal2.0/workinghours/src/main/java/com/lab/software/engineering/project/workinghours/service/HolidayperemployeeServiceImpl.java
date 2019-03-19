package com.lab.software.engineering.project.workinghours.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab.software.engineering.project.workinghours.dao.EmployeeRepository;
import com.lab.software.engineering.project.workinghours.dao.HolidayperemployeeRepository;
import com.lab.software.engineering.project.workinghours.entity.Employee;
import com.lab.software.engineering.project.workinghours.entity.Holidayperemployee;

@Service
public class HolidayperemployeeServiceImpl implements HolidayperemployeeService{

	
	@Autowired
	private HolidayperemployeeRepository holidayperemployeeRepository;
	@Autowired
	private EmployeeRepository employeeRepository;
//	@Override
//	public List<Holidayperemployee> getHolidayperemployee() {
//	
//		return holidayperemployeeRepository.findAll();
//	}
	@Override
	public List<Holidayperemployee> getHolidaysByEmployeeId(long employeeid){
		Optional<Employee> emp = employeeRepository.findById(employeeid);
		return holidayperemployeeRepository.getHolidaysByEmployeeId(emp);
	}
	
	@Override
	public void saveHolidayperemployee(Holidayperemployee holidayperemployee,long employeeid) {

	holidayperemployee.setHolidayperemployeeid(0);
	Employee employee=null;
	
	Optional<Employee> emp = employeeRepository.findById(employeeid);
	if (emp.isPresent()) {
		employee = emp.get();
	}
	holidayperemployee.setEmployee(employee);
	
	holidayperemployeeRepository.save(holidayperemployee);
	}
}
