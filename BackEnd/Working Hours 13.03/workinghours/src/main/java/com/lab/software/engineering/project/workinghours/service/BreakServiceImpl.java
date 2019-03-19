package com.lab.software.engineering.project.workinghours.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab.software.engineering.project.workinghours.dao.BreakRepository;
import com.lab.software.engineering.project.workinghours.dao.EmployeeRepository;
import com.lab.software.engineering.project.workinghours.entity.Break;
import com.lab.software.engineering.project.workinghours.entity.Employee;
import com.lab.software.engineering.project.workinghours.entity.Workingday;

@Service
public class BreakServiceImpl implements BreakService {

	@Autowired
	private BreakRepository breakRepository;
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@Override
	public void saveBreak(Break br, long employeeid) {
		
		LocalDateTime breakstarted = br.getBreakstarted();
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

            if((w.getCheckin().getYear() == breakstarted.getYear()) && (w.getCheckin().getMonth() == breakstarted.getMonth()) && (w.getCheckin().getDayOfMonth() == breakstarted.getDayOfMonth()) && (w.getCheckin().getDayOfMonth() == breakstarted.getDayOfMonth()) && (employeeid==w.getEmployee().getEmployeeid())) {
                workingday = w;
            }
        }
        br.setWorkingday(workingday);
       
        breakRepository.save(br);
	}


	@Override
	public void updateBreak(Object br, long employeeid) {
		// TODO Auto-generated method stub
		 	String ch = br.toString();
	     
	        String[] datum = ch.split("=");

	        String checkout = datum[1].substring(0, datum[1].length()-1);
	       
	        System.out.println(checkout);
	        LocalDateTime breakended = LocalDateTime.parse(checkout);
	        Optional<Employee> result= employeeRepository.findById(employeeid);
	        Employee theEmployee=null;
	        if(result.isPresent()) {
	            
	            theEmployee=result.get();
	            
	        }else {
	            throw new RuntimeException("Did not find employee id: "+employeeid);
	        }
	        
	        List<Workingday> workingdays = theEmployee.getWorkingdays();
	        Break breeak = null;
	        for(Workingday wd: workingdays) {
	        	List<Break> breaks = wd.getBreaks();
	        	
	        	for(Break br1: breaks) {
	        		if((br1.getBreakstarted().getYear() == breakended.getYear()) && 
	        		(br1.getBreakstarted().getMonth() == breakended.getMonth()) && 
	        		(br1.getBreakstarted().getDayOfMonth() == breakended.getDayOfMonth()) && 
	        		(br1.getBreakstarted().getDayOfMonth() == breakended.getDayOfMonth()) && 
	        		(employeeid==wd.getEmployee().getEmployeeid()) && (wd.getWorkingdayid()==br1.getWorkingday().getWorkingdayid())) {
		                breeak = br1;
		            }
	        	}
	        	
	        }
	        
	        
	       
	        breeak.setBreakended(breakended);
	        breakRepository.save(breeak);
	        
	}
	
}
