package com.lab.software.engineering.project.workinghours.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab.software.engineering.project.workinghours.entity.Break;
import com.lab.software.engineering.project.workinghours.service.BreakService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class BreakRestController {
	
	@Autowired
	private BreakService breakService;
	
	@PostMapping("/employees/{employeeid}/workingday/break")
	public void saveBreak(@RequestBody Break br, @PathVariable long employeeid) {

		breakService.saveBreak(br, employeeid);
		
	}
	
	@PutMapping("/employees/{employeeid}/workingday/break")
	    public void updateBreak(@RequestBody Object checkout1, @PathVariable long employeeid) {
	       
	        breakService.updateBreak(checkout1, employeeid);
	        
	}
}
