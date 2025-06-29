package com.sprint1.ebs.payment.service;

import java.util.List;

import com.sprint1.ebs.payment.entity.Payment;
import com.sprint1.ebs.payment.exception.PaymentIdNotFoundException;

public interface PaymentService {

	Payment getPaymentById(Long id) throws PaymentIdNotFoundException;

	List<Payment> listAllPayments();

	Payment createPayment(Payment p);

}
