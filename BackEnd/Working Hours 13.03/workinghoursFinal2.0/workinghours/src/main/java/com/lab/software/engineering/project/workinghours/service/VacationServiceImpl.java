package com.lab.software.engineering.project.workinghours.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab.software.engineering.project.workinghours.dao.EmployeeRepository;
import com.lab.software.engineering.project.workinghours.dao.VacationRepository;
import com.lab.software.engineering.project.workinghours.entity.Employee;
import com.lab.software.engineering.project.workinghours.entity.Vacation;

@Service
public class VacationServiceImpl implements VacationService {

	@Autowired
	private VacationRepository vacationRepository;
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Vacation> getVacation() {
		return vacationRepository.findAll();
	}

	@Override
	public List<Vacation> getVacationByEmployeeID(long employeeid) {
		// TODO Auto-generated method stub
		Optional<Employee> emp = employeeRepository.findById(employeeid);
		return vacationRepository.getVacationByEmployeeID(emp);

	}

	@Override

	public void saveVacationByEmployeeId(Vacation vacation, long employeeid) {
		vacation.setVacationid(0);
		Employee employee = null;

		Optional<Employee> emp = employeeRepository.findById(employeeid);
		if (emp.isPresent()) {
			employee = emp.get();
		}
		vacation.setEmployee(employee);
		
		vacationRepository.save(vacation);
	}
//	@Override
//	public List<Vacation> getVacationByEmployeeID(long employeeid) {
//		return vacationRepository.;
//	}

}
