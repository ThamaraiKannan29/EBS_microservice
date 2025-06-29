package com.sprint1.ebs.bill.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sprint1.ebs.bill.dto.EbsConnection;
import com.sprint1.ebs.bill.dto.Payment;
import com.sprint1.ebs.bill.entitie.Bill;
import com.sprint1.ebs.bill.exception.BillNotFoundException;
import com.sprint1.ebs.bill.service.BillService;


@RestController
@RequestMapping("/billing")
public class BillController {
	
	@Autowired
	BillService service;
	
	@Autowired
    RestTemplate template;
	
	@PostMapping("/admin/create-bill")
	public Bill createBill(@Valid @RequestBody Bill bill) {
		return service.createBill(bill);
	}
	
	
	@GetMapping("/admin/list-all")
	public List<Bill> listAll(){
		return service.listAll();
	}

	@PatchMapping("/admin/update-bill/{billID}")
	public Bill updateBill( @RequestBody Bill bill, @PathVariable Long billID) throws BillNotFoundException {
		return service.updateBill(bill, billID);
		
	}
	@GetMapping("/connection/{connID}/listall/{status}")
	public List<Bill> listAllPaidOrUnpaidByConnID(@PathVariable long connID,@PathVariable boolean status) {
		return service.listAllPaidOrUnpaidByConnID(connID,status);
	}
	
	@GetMapping("/admin/list-all/{status}")
	public List<Bill> listAllPaidOrUnpaid(@PathVariable boolean status){
		return service.listAllPaidOrUnpaid(status);
	}
	
	@GetMapping("/admin/list/{billID}")
	public Bill listById(@PathVariable Long billID) throws BillNotFoundException {
		return service.listById(billID);
		
	}
	
	@GetMapping("/customer/{custID}/connection/{connID}/billing/{billID}/payment")
	public Payment makePayment(@PathVariable Long connID,@PathVariable Long billID,@PathVariable Long custID ) throws BillNotFoundException {
		Bill b = service.listById(billID);
		Payment p = template.getForObject("http://localhost:9696/electricity-billing-service/payment/billing"+billID+"/makepayment", Payment.class);
		b.setStatus(true);
		service.updateBill(b, billID);
		return p;
	}
	
	@GetMapping("/connection/{connID}/list-all")
	public List<Bill> listAll(@PathVariable Long connID){
		return service.listAllBill(connID);
	}
	
	
	

}
