package com.devsuperior.hrworker.payroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.devsuperior.hrworker.payroll.entities.Payment;
import com.devsuperior.hrworker.payroll.entities.Worker;
import com.devsuperior.hrworker.payroll.feingclients.WorkerFeingClient;

@Service
public class PaymentServices {
	
	@Value("${hr-worker.host}")
	private String workerHost;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private WorkerFeingClient workerFeingClient;
	
	public Payment getPayment(long workerId, int days) {

		Worker worker = workerFeingClient.findById(workerId).getBody();
		
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
	
/*	public Payment getPayment(long workerId, int days) {
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("id", ""+workerId);
		
		Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}"	, Worker.class, uriVariables);
		
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}*/
	
}
