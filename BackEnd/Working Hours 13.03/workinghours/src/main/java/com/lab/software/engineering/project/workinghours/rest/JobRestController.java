package com.lab.software.engineering.project.workinghours.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lab.software.engineering.project.workinghours.dao.WorkingdayRepository;
import com.lab.software.engineering.project.workinghours.entity.Employee;
import com.lab.software.engineering.project.workinghours.entity.Job;
import com.lab.software.engineering.project.workinghours.entity.Workingday;
import com.lab.software.engineering.project.workinghours.service.EmployeeService;
import com.lab.software.engineering.project.workinghours.service.JobService;
import com.lab.software.engineering.project.workinghours.service.WorkingdayService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class JobRestController {
	@Autowired
	private JobService jobService;


	@GetMapping("/jobs")
	public List<Job> getJobs() {
	
	return jobService.getAll();
	}
	

	@PostMapping("/jobs")
	public Job saveJob(@RequestBody Job job) {
	jobService.saveJob(job);
	return job;
	}



}