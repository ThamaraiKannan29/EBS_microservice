package com.sprint1.ebs.user.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sprint1.ebs.user.dto.Bill;

@FeignClient(name="ebs-bill", url = "http://bill-service-container:9898/")
public interface EbsBillProxy {
	
	@PostMapping("/electricity-billing-service/billing/admin/create-bill")
	public Bill createBill(@RequestBody Bill bill);
	
	@PatchMapping("/electricity-billing-service/billing/admin/update-bill/{billID}")
	public Bill updateBill(@RequestBody Bill bill,@PathVariable("billID") Long billID);
	
	@GetMapping("/electricity-billing-service/billing/admin/list-all/{status}")
	public List<Bill> listAllPaidOrUnpaid(@PathVariable("status") boolean status);
	
	@GetMapping("/electricity-billing-service/billing/connection/{connID}/list-all")
	public List<Bill> listAllBillsForConnection(@PathVariable("connID") Long connID);
	
	@GetMapping("/electricity-billing-service/billing/connection/{connID}/listall/{status}")
	public List<Bill> listAllPaidOrUnpaidByConnID(@PathVariable("connID") Long connID,@PathVariable("status") boolean status);
	
}