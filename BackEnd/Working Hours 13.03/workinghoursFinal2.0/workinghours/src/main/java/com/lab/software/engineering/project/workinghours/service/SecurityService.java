package com.lab.software.engineering.project.workinghours.service;

public interface SecurityService {
	
	 String findLoggedInUsername();
     void autoLogin(String username, String password);
	
}
