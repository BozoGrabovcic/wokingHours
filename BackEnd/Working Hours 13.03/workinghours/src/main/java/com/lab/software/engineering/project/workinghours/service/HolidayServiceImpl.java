package com.lab.software.engineering.project.workinghours.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab.software.engineering.project.workinghours.dao.EmployeeRepository;
import com.lab.software.engineering.project.workinghours.dao.HolidayRepository;
import com.lab.software.engineering.project.workinghours.entity.Holiday;

@Service
public class HolidayServiceImpl implements HolidayService{

	
	@Autowired
	private HolidayRepository holidayRepository;
	
	@Override
	public List<Holiday> getHolidays() {
		return holidayRepository.findAll();
	}

	@Override
	public void saveHoliday(Holiday holiday) {
		holidayRepository.save(holiday);
		
	}

}
