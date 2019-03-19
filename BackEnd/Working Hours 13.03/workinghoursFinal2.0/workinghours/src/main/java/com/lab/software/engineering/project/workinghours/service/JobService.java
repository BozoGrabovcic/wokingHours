
package com.lab.software.engineering.project.workinghours.service;
import java.util.List;

import com.lab.software.engineering.project.workinghours.entity.Employee;
import com.lab.software.engineering.project.workinghours.entity.Job;
import com.lab.software.engineering.project.workinghours.entity.Workingday;



public interface JobService {
	public void saveJob(Job theJob);
	public List<Job> getAll();
}