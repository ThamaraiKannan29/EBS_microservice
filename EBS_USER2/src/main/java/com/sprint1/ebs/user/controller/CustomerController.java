package com.sprint1.ebs.user.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.sprint1.ebs.user.dto.Bill;
import com.sprint1.ebs.user.dto.EbsConnection;
import com.sprint1.ebs.user.dto.Payment;
import com.sprint1.ebs.user.entities.Customer;
import com.sprint1.ebs.user.service.UserService;

@RestController
public class CustomerController {

	Logger log=LoggerFactory.getLogger(CustomerController.class);
	@Autowired
	private UserService service;
	
	@Autowired
	EbsPaymentProxy paymentProxy;
	
	@Autowired
	EbsBillProxy billProxy;
	
	@Autowired
	EbsConnectionProxy connectionProxy;
	
	@GetMapping("/customer/{custId}/connections")
	public List<EbsConnection> getAllConnections(@PathVariable("custId") Long custId)
	{
		return connectionProxy.getAllConnectionsForCustomer(custId);
	}
	
	@PostMapping("/register")
	public Customer addCustomer(@Valid @RequestBody Customer customer)
	{
		log.info("adding a customer");
		return service.addCustomer(customer);
	}
	
	@GetMapping("/customer/{custId}/listAllPayment")
	public List<Payment> listAllPayment(@PathVariable("custId") Long custId) {
		List<Payment> payment = new ArrayList<Payment>();
	    List<EbsConnection> ebsConnection = connectionProxy.getAllConnectionsForCustomer(custId);
		for(EbsConnection ebs : ebsConnection) {
	        List<Bill> bill = billProxy.listAllBillsForConnection(ebs.getConnID());
	        for(Bill b : bill) {
	        System.out.println(b);
	        payment.add(paymentProxy.getPaymentByID(b.getBillID()));
	        }
	    }
	    return payment;	
	}
	
	@GetMapping("/customer/{custId}/connection/{connID}/bills")
	public List<Bill> listBillsForConnection(@PathVariable("connID") Long connID){
		return billProxy.listAllBillsForConnection(connID);
	}
	
	@GetMapping("/customer/{custID}/connections/billing")
	public List<Bill> listBills(@PathVariable("custID") Long custID){
		List<Bill> bill = null;
		List<Bill> b = new ArrayList<Bill>();
		List<EbsConnection> ebsConnection =  connectionProxy.getAllConnectionsForCustomer(custID);
		for(EbsConnection con : ebsConnection) {
			bill = billProxy.listAllBillsForConnection(con.getConnID());
			for(Bill b1:bill) {
				b.add(b1);
			}
		}
		return b;
	}
	
	
	@GetMapping("/customer/{custID}/connections/{status}")
	public List<Bill> listBillsByStatusForCustomer(@PathVariable("custID") Long custID, @PathVariable("status") boolean status){
		List<Bill> bill = null;
		List<Bill> b = new ArrayList<Bill>();
		List<EbsConnection> ebsConnection =  connectionProxy.getAllConnectionsForCustomer(custID);
		for(EbsConnection con : ebsConnection) {
			bill = billProxy.listAllPaidOrUnpaidByConnID(con.getConnID(),status);
			for(Bill b1: bill) {
				b.add(b1);
			}
		}
		return b;
	}
	
	@GetMapping("/customer/{custId}/connection/{connID}/listAllPayment")
	public List<Payment> listAllPaymentForConnection(@PathVariable("custId") Long custID,@PathVariable("connID") Long connID) {
		List<Payment> payment = new ArrayList<Payment>();
			List<Bill> bill = billProxy.listAllBillsForConnection(connID);
			for(Bill b : bill) {
			 payment.add(paymentProxy.getPaymentByID(b.getBillID()));
		}
		return payment;	
	}
	//@GetMapping("/customer/{custID}/connections/{connID}/billing/{billID}/payment")
	
	/*@PutMapping("/customer/{id}")
    public Customer updateCustomer(@RequestBody Customer customer,@PathVariable Long id) throws CustomerIdNotFoundException
    {
        return service.updateCustomer(customer,id);
    }*/
}
