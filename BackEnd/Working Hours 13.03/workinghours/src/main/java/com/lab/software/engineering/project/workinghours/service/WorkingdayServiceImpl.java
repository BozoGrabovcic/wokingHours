package com.lab.software.engineering.project.workinghours.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lab.software.engineering.project.workinghours.dao.EmployeeRepository;
import com.lab.software.engineering.project.workinghours.dao.WorkingdayRepository;
import com.lab.software.engineering.project.workinghours.entity.Employee;
import com.lab.software.engineering.project.workinghours.entity.Weekday;
import com.lab.software.engineering.project.workinghours.entity.Workingday;

@Service
public class WorkingdayServiceImpl implements WorkingdayService {

	// // need to inject Employee dao
	@Autowired
	private WorkingdayRepository workingDayRepository;
	@Autowired
	private EmployeeRepository employeeRepository;

	
	
	@Override
	public List<Workingday> employeeWithWorkingday() {
		return workingDayRepository.findAll();
	}

	//
	@Override

	public void saveWorking(Workingday w, long employeeid) {
		w.setWorkingdayid(0);
		Employee employee = null;
		Optional<Employee> emp = employeeRepository.findById(employeeid);
		if (emp.isPresent()) {
			employee = emp.get();

		} else {
			System.out.println("Cannot find employee");
			employee = null;
		}
		w.setEmployee(employee);
		workingDayRepository.save(w);
	}

	public void setWeekday(Workingday w) {
		Weekday weekday = new Weekday();
		String day = w.getCheckin().getDayOfWeek().toString();
		weekday.setName(day);
		switch (day) {
		case "MONDAY":
			weekday.setWeekdayid(1l);
			break;

		case "TUESDAY":
			weekday.setWeekdayid(2l);
			break;
		case "WEDNESDAY":
			weekday.setWeekdayid(3l);
			break;
		case "THURSDAY":
			weekday.setWeekdayid(4l);
			break;
		case "FRIDAY":
			weekday.setWeekdayid(5l);
			break;
		case "SATURDAY":
			weekday.setWeekdayid(6l);
			break;
		case "SUNDAY":
			weekday.setWeekdayid(7l);
			break;
		}
		w.setWeekday(weekday);
	}

	//
	@Override

	public Workingday getWorkingday(long theId) {

		Optional<Workingday> result = workingDayRepository.findById(theId);
		Workingday theEmployee = null;
		if (result.isPresent()) {
			theEmployee = result.get();
		} else {
			throw new RuntimeException("Did not find employee id: " + theId);
		}
		return theEmployee;
	}
	
	@Override
	@Transactional
	public List<Workingday> getWorkingDaysByEmployeeID(long employeeid) {
		// TODO Auto-generated method stub
		
		Optional<Employee> result= employeeRepository.findById(employeeid);
		Employee theEmployee=null;
		if(result.isPresent()) {
			theEmployee=result.get();
		}else {
			throw new RuntimeException("Did not find employee id: "+employeeid);
		}
	
		return workingDayRepository.getWorkingDaysByEmployeeID(theEmployee);
	}
	
	@Override
	public void updateWorkingDay(String checkoutString, long employeeid) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); 
		LocalDateTime checkout = LocalDateTime.parse(checkoutString, formatter);

		System.out.println(checkout + " empl: "+ employeeid);
		Optional<Employee> result= employeeRepository.findById(employeeid);
		Employee theEmployee=null;
		if(result.isPresent()) {
			
			theEmployee=result.get();
			
		}else {
			throw new RuntimeException("Did not find employee id: "+employeeid);
		}
		List<Workingday> workingdays = theEmployee.getWorkingdays();
		Workingday workingday = null;
		for(Workingday w: workingdays) {

			if((w.getCheckin().getYear() == checkout.getYear()) && (w.getCheckin().getMonth() == checkout.getMonth()) && (w.getCheckin().getDayOfMonth() == checkout.getDayOfMonth()) && (w.getCheckin().getDayOfMonth() == checkout.getDayOfMonth()) && (employeeid==w.getEmployee().getEmployeeid())) {
				workingday = w;
			}
		}
		workingday.setCheckout(checkout);
		workingDayRepository.save(workingday);
	}
	
	public long durattion(Workingday w) {
		Duration duration = Duration.between(w.getCheckin(), w.getCheckout());
		long diff = Math.abs(duration.toMinutes());
		return diff;
	}

	@Override
	public List<Workingday> findOvertime() {
		List<Workingday> overtimeList=new ArrayList<Workingday>();
		List<Workingday> workingdays=employeeWithWorkingday();
		for (Workingday workingday : workingdays) {
			if(workingday.getWorkDuration()>480) {
				overtimeList.add(workingday);
			}		
		}
		return overtimeList;
	}

	@Override
	public List<Workingday> findOvertimeFromDateToDate(LocalDateTime checkin,LocalDateTime checkin1) {
		
		return workingDayRepository.findOvertimeFromDateToDate(checkin,checkin1);
	}
	
	//
	// @Override
	//
	// public void deleteEmployee(long theId) {
	//
	// employeeRepository.deleteById(theId);
	// }
	//
	// @Override
	// public List<Employee> findBySearchTerm(String searchTerm) {
	// return employeeRepository.findBySearchTerm(searchTerm);
	// }
	//
	// @Override
	// public List<Employee> findByActive() {
	// return employeeRepository.findByActive();
	// }
	//
	// @Override
	// public List<Workingday> employeeWithWorkingday() {
	// return wr.employeeWithWorkingday();
	// }

	

}
