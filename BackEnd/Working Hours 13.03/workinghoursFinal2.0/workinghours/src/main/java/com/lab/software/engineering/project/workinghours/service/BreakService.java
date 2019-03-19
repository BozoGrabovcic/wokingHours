package com.lab.software.engineering.project.workinghours.service;

import com.lab.software.engineering.project.workinghours.entity.Break;

public interface BreakService {

	public void saveBreak(Break br, long employeeid);
	public void updateBreak(Object br, long employeeid);
}
