package com.devsuperior.hrworker.payroll.services;

import org.springframework.stereotype.Service;

import com.devsuperior.hrworker.payroll.entities.Payment;

@Service
public class PaymentServices {
	
	public Payment getPayment(long workerId, int days) {
		return new Payment("Bod", 200.0, days);
	}
	
}
