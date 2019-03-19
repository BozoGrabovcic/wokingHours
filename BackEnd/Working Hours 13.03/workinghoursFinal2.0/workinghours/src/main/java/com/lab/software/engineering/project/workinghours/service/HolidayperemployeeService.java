package com.lab.software.engineering.project.workinghours.service;

import java.util.List;

import com.lab.software.engineering.project.workinghours.entity.Employee;
import com.lab.software.engineering.project.workinghours.entity.Holidayperemployee;

public interface HolidayperemployeeService {
	
	public List<Holidayperemployee> getHolidaysByEmployeeId(long employeeid);

	public void saveHolidayperemployee(Holidayperemployee holidayperemployee,long employeeid);
}
