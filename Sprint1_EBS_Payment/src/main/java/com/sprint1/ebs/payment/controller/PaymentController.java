package com.sprint1.ebs.payment.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprint1.ebs.payment.entity.Payment;
import com.sprint1.ebs.payment.exception.PaymentIdNotFoundException;
import com.sprint1.ebs.payment.service.PaymentService;

@RestController
@RequestMapping("payment")
public class PaymentController {
	
	@Autowired
	PaymentService service;
	
	@GetMapping("/payment/{id}")
	public Payment getPaymentReceipt(@PathVariable("id")Long id) throws PaymentIdNotFoundException {
		return service.getPaymentById(id);
	}
	
	@GetMapping("/listallpayments")
	public List<Payment> listAllPayment(){
		return service.listAllPayments();
	}
	
	@PostMapping("billing/{billID}/makepayment")
	public Payment createPayment(@PathVariable Long billID) {
		Payment p = new Payment();
		p.setBillID(billID);
		p.setPaymentDate(LocalDate.now());
		return service.createPayment(p);
	}
}
