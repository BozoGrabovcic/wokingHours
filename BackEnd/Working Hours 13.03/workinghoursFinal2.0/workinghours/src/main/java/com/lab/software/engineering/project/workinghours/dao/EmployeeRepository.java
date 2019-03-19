package com.lab.software.engineering.project.workinghours.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lab.software.engineering.project.workinghours.entity.Employee;
import com.lab.software.engineering.project.workinghours.entity.Workingday;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	@Query("Select e FROM Employee e WHERE e.username=?1")
	Employee findByUsername(String username);
	 @Query("SELECT t FROM Employee t WHERE t.active=true")
	 List<Employee> findByActive();
	 
//	 @Query("SELECT com.lab.software.engineering.project.workinghours.entity.WorkingdayEmpDto.java(d.name, e.name, e.email, e.address) "
//				+ "FROM  d INNER JOIN d.employees e")
//		List<WorkingdayEmpDto> fetchEmpDeptDataInnerJoin();
//	 @Query("SELECT t FROM Employee t WHERE t.active=true")
//	 List<Employee> findByActive();
}
