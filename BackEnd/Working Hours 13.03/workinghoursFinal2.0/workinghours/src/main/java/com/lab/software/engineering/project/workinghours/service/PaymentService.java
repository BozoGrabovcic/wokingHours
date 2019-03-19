package com.lab.software.engineering.project.workinghours.service;

import java.util.List;

import com.lab.software.engineering.project.workinghours.entity.Payment;

public interface PaymentService {

	public List<Payment> getPayment();
	public List<Payment> getPaymentByEmployeeId(long employeeid);
}
