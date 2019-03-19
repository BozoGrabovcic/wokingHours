
package com.lab.software.engineering.project.workinghours.service;
import java.time.LocalDateTime;
import java.util.List;

import com.lab.software.engineering.project.workinghours.entity.Workingday;



public interface WorkingdayService {
	public List<Workingday> employeeWithWorkingday();
	public void saveWorking(Workingday w, long employeeid);
	public void setWeekday(Workingday w);
	 public Workingday getWorkingday(long theId);
	 public List<Workingday> getWorkingDaysByEmployeeID(long employeeid);
	 public void updateWorkingDay(String checkoutString, long employeeid);
	 public List<Workingday> findOvertime();
		List<Workingday> findOvertimeFromDateToDate(LocalDateTime checkin,LocalDateTime checkin1);
}