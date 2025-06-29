package com.sprint1.ebs.payment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint1.ebs.payment.entity.Payment;
import com.sprint1.ebs.payment.exception.PaymentIdNotFoundException;
import com.sprint1.ebs.payment.repo.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentRepository repo;

	@Override
	public Payment getPaymentById(Long id) throws PaymentIdNotFoundException {
		// TODO Auto-generated method stub
		return repo.findById(id).orElseThrow(PaymentIdNotFoundException::new);
	}

	@Override
	public List<Payment> listAllPayments() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Payment createPayment(Payment p) {
		// TODO Auto-generated method stub
		return repo.save(p);
	}
	
	
}
