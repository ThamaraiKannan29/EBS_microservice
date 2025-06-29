package com.sprint1.ebs.user.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sprint1.ebs.user.dto.Payment;

@FeignClient(name="ebs-payment", url = "http://payment-service-container:9696/" )
public interface EbsPaymentProxy {

	@GetMapping("electricity-billing-service/payment/payment/{id}")
	public Payment getPaymentByID(@PathVariable("id")Long id);
}
