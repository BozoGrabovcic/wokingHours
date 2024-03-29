package com.lab.software.engineering.project.workinghours.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab.software.engineering.project.workinghours.entity.Payment;
import com.lab.software.engineering.project.workinghours.service.PaymentService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class PaymentRestController {
	
	@Autowired
	private PaymentService paymentService;
	
	@GetMapping("/payments")
	public List<Payment> getAll(){
		return paymentService.getPayment();
	}
	@GetMapping("/employees/{employeeid}/payments")
	public List<Payment> getPaymentByEmployeeId(@PathVariable Long employeeid){
		return paymentService.getPaymentByEmployeeId(employeeid);
	}
}
