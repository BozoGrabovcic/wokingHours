package com.lab.software.engineering.project.workinghours.rest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab.software.engineering.project.workinghours.entity.Workingday;
import com.lab.software.engineering.project.workinghours.service.WorkingdayService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class WorkingdayRestController {

	@Autowired
	private WorkingdayService workingDayService;

	@GetMapping("/all")
	public List<Workingday> getAll() {
		return workingDayService.employeeWithWorkingday();
	}

	 @GetMapping("/workingdays/{workingdayid}")
	 public Workingday getWorkingdayByID(@PathVariable long workingdayid) {
	 return workingDayService.getWorkingday(workingdayid);
	 }
	
	@PostMapping("/employees/{employeeid}/workingday")
	public Workingday saveWorking(@RequestBody Workingday w, @PathVariable long employeeid) {
//	
		workingDayService.setWeekday(w);
		System.out.println("Working day: " + w);
		
		workingDayService.saveWorking(w, employeeid);
		return w;
	}
	
	@GetMapping("/employees/{employeeid}/workingdays")
	public List<Workingday> getWorkingDaysByEmployeeID(@PathVariable long employeeid){
//		return employeeRepository.findById(employeeid);
		return workingDayService.getWorkingDaysByEmployeeID(employeeid);
	}
	@PutMapping("/employees/{employeeid}/workingday")
	public void updateWorking(@RequestBody Object checkout1, @PathVariable long employeeid) {
		String ch = checkout1.toString();
		String[] datum = ch.split("=");
		String checkout = datum[1].substring(0, datum[1].length()-1);
		String checkoutF = checkout.replace("T", " ");
		System.out.println("|" + checkoutF + "|");
		workingDayService.updateWorkingDay(checkoutF, employeeid);
		
	}
	 @GetMapping("/workingdays/overtime")
	 public List<Workingday> findOvertime() {
		 
	 return workingDayService.findOvertime();
	 }
	 

	 @GetMapping("/workingdays/after/{checkin}/{checkin1}")
	 public List<Workingday> findAfter(@PathVariable String checkin,@PathVariable String checkin1) {
		 checkin=checkin+"T00:00:00";
		 checkin1=checkin1+"T00:00:00";
		 List<Workingday> overtimeList=new ArrayList<Workingday>();
		LocalDateTime checkin01=LocalDateTime.parse(checkin);
		LocalDateTime checkin11=LocalDateTime.parse(checkin1);
		List<Workingday> workingdays=workingDayService.findOvertimeFromDateToDate(checkin01,checkin11);
		for (Workingday workingday : workingdays) {
			if(workingday.getWorkDuration()>480) {
				overtimeList.add(workingday);
			}		
		}
		return overtimeList;
	}
	// @DeleteMapping("/employees/{employeeid}")
	// public String deleteEmployeeByID(@PathVariable long employeeid) {
	// Employee employee=employeeService.getEmployee(employeeid);
	// employeeService.deleteEmployee(employeeid);
	// return "Employee "+employee.toString()+" deleted";
	// }
	// @RequestMapping("/employees/search/{name}")
	// public List<Employee> getEmployeeByID(@PathVariable String name) {
	// String nameUpperCase=name.toUpperCase();
	// return employeeService.findBySearchTerm(nameUpperCase);
	// }
	// @RequestMapping("/employees/active")
	// public List<Employee> getActiveEmployee() {
	//
	// return employeeService.findByActive();
	// }
	// @RequestMapping("/employees/workingday")
	// public List<Workingday> employeeWithWorkingday() {
	//
	// return wr.employeeWithWorkingday();
	// }
}