package com.lab.software.engineering.project.workinghours.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab.software.engineering.project.workinghours.dao.EmployeeRepository;
import com.lab.software.engineering.project.workinghours.dao.HolidaytypeRepository;
import com.lab.software.engineering.project.workinghours.entity.Holidaytype;
@Service
public class HolidaytypeServiceImpl implements HolidaytypeService {

	@Autowired
	private HolidaytypeRepository holidaytypeRepository;
	
	@Override
	public List<Holidaytype> getHolidaytype() {
		return holidaytypeRepository.findAll();
	}

	@Override
	public void saveHolidaytype(Holidaytype holidayType) {
		holidaytypeRepository.save(holidayType);
		
	}
}
