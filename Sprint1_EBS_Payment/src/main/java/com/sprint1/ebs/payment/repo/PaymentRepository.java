package com.sprint1.ebs.payment.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprint1.ebs.payment.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
	
	List<Payment> findByPaymentDate(LocalDate paymentDate);
}
