package com.devsuperior.hrworker.payroll.ressources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.hrworker.payroll.entities.Payment;
import com.devsuperior.hrworker.payroll.services.PaymentServices;

@RestController
@RequestMapping(value = "/payments")
public class PaymentRessources {
	
	@Autowired
	private PaymentServices paymentServices;
	
	@GetMapping(value = "/{workerId}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days){
		Payment payment = paymentServices.getPayment(workerId, days);
		
		return ResponseEntity.ok(payment);
	}
	
}
