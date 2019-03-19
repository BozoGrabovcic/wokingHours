package com.lab.software.engineering.project.workinghours.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lab.software.engineering.project.workinghours.dao.EmployeeRepository;
import com.lab.software.engineering.project.workinghours.entity.Employee;
import com.lab.software.engineering.project.workinghours.entity.Role;
@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	EmployeeRepository employeeRepository;

	 @Override
	    @Transactional(readOnly = true)
	    public UserDetails loadUserByUsername(String username) {
	        Employee employee = employeeRepository.findByUsername(username);
	        if (employee == null) throw new UsernameNotFoundException(username);

	        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
	        for (Role role : employee.getRoles()){
	            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
	        }

	        return new org.springframework.security.core.userdetails.User(employee.getUsername(), employee.getPassword(), grantedAuthorities);
	    }

}
