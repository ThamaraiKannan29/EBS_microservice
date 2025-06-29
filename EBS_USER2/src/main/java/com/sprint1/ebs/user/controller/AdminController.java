package com.sprint1.ebs.user.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sprint1.ebs.user.dto.Bill;
import com.sprint1.ebs.user.entities.Customer;
import com.sprint1.ebs.user.exception.CustomerIdNotFoundException;
import com.sprint1.ebs.user.service.UserService;

@RestController
public class AdminController {

	Logger log=LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private UserService service;
	
	@Autowired
	EbsBillProxy billProxy;
	
	@PostMapping("/admin/customer")
	public Customer addCustomer(@Valid @RequestBody Customer customer) {
		
		log.info("Adding customer");
		return service.addCustomer(customer);
	}
	@GetMapping("/admin/customer/{custID}")
	public Customer findCustomerById(@PathVariable("custID")Long id) throws CustomerIdNotFoundException{
		log.info("listing customer by ID");
		return service.findById(id);
	}
	
	@DeleteMapping("/admin/customer/{custID}")
	public String deleteCustomer(@PathVariable("custID") Long id){
		log.info("Deleting customer by ID");
		service.deleteCustomer(id);
		return "Customer deleted successfully";
	} 
	
	@GetMapping("/admin/customers")
	public List<Customer> listAllCustomers(){
		log.info("Listing all customer");
		return service.listAllCustomers();
	}	
	
	@PutMapping("/admin/customer/{custID}")
	public Customer updateCustomer(@RequestBody Customer customer,@PathVariable("custID")Long id) throws CustomerIdNotFoundException{
		log.info("updating a customer by ID");
	    return service.updateCustomer(customer,id);
	}
	
	@PostMapping("/admin/create-bill")
	public Bill createBill(@RequestBody Bill bill) {
		log.info("Create Bill");
		return billProxy.createBill(bill);
	}
	
	@PatchMapping("/admin/update-bill/{billID}")
	public Bill updateBill(@RequestBody Bill bill,@PathVariable("billID") Long billID) {
		log.info("update Bill");
		return billProxy.updateBill(bill, billID);
	}
	
	@GetMapping("/admin/list-all/{status}")
	public List<Bill> listAllPaidOrUnpaid(@PathVariable("status") boolean status){
		return billProxy.listAllPaidOrUnpaid(status);
	}
}
