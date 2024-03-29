package com.lab.software.engineering.project.workinghours.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lab.software.engineering.project.workinghours.entity.Employee;
import com.lab.software.engineering.project.workinghours.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    @Query("Select p FROM Payment p WHERE p.employee=?1")
	List<Payment>getPaymentByEmployeeId(Optional<Employee>emp);
}
