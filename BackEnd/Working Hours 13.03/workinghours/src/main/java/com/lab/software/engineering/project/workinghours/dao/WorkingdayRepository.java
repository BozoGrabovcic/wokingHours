package com.lab.software.engineering.project.workinghours.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lab.software.engineering.project.workinghours.entity.Employee;
import com.lab.software.engineering.project.workinghours.entity.Workingday;

public interface WorkingdayRepository extends JpaRepository<Workingday, Long> {
//	@Query("SELECT w FROM Workingday w INNER JOIN w.employeeid WHERE t.active=true")
//	 List<Workingday> employeeWithWorkingday();
	@Query("Select w FROM Workingday w WHERE w.employee=?1")
	List<Workingday> getWorkingDaysByEmployeeID(Employee emp);
	 @Query("FROM Workingday w WHERE w.checkin>:checkin AND w.checkin<:checkin1")
	 List<Workingday> findOvertimeFromDateToDate(@Param("checkin") LocalDateTime checkin,@Param("checkin1") LocalDateTime checkin1);
}
