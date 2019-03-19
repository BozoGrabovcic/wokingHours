package com.lab.software.engineering.project.workinghours.service;

import com.lab.software.engineering.project.workinghours.entity.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserPrinciple implements UserDetails {
	
	private static final long serialVersionUID = 1L;

	private Long employeeid;

    private String firstname;
    
    private String lastname;

    private String username;

    private String email;

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public UserPrinciple(Long employeeid, String firstname, String lastname,
			    		String username, String email, String password, 
			    		Collection<? extends GrantedAuthority> authorities) {
        this.employeeid = employeeid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    public static UserPrinciple build(Employee employee) {
        List<GrantedAuthority> authorities = employee.getRoles().stream().map(role ->
                new SimpleGrantedAuthority(role.getName().name())
        ).collect(Collectors.toList());

        return new UserPrinciple(
                employee.getEmployeeid(),
                employee.getFirstname(),
                employee.getLastname(),
                employee.getUsername(),
                employee.getEmail(),
                employee.getPassword(),
                authorities
        );
    }

   public Long getEmployeeid() {
		return employeeid;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastName() {
		return lastname;
	}

	public void setLastName(String lastName) {
		this.lastname = lastName;
	}

	public String getEmail() {
        return email;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        UserPrinciple employee = (UserPrinciple) o;
        return Objects.equals(employeeid, employee.employeeid);
    }
}