package com.lab.software.engineering.project.workinghours.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab.software.engineering.project.workinghours.dao.EmployeeRepository;
import com.lab.software.engineering.project.workinghours.dao.PaymentRepository;
import com.lab.software.engineering.project.workinghours.entity.Employee;
import com.lab.software.engineering.project.workinghours.entity.Payment;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Payment> getPayment() {

		return paymentRepository.findAll();
	}
	
	public List<Payment> getPaymentByEmployeeId(long employeeid){
		Optional<Employee> emp = employeeRepository.findById(employeeid);
		return paymentRepository.getPaymentByEmployeeId(emp);
	}

}
