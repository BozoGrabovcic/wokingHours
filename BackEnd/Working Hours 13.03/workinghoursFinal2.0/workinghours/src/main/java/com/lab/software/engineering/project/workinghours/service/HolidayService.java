package com.lab.software.engineering.project.workinghours.service;

import java.util.List;


import com.lab.software.engineering.project.workinghours.entity.Holiday;

public interface HolidayService {
	
	
	public List<Holiday> getHolidays();
	
	public void saveHoliday(Holiday holiday);
}
