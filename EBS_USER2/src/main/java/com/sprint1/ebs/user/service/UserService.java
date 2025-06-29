package com.sprint1.ebs.user.service;


import java.util.List;

import com.sprint1.ebs.user.entities.Customer;
import com.sprint1.ebs.user.entities.User;
import com.sprint1.ebs.user.exception.CustomerIdNotFoundException;


public interface UserService {

	User addAdmin(User u);
	Customer addCustomer(Customer customer);
	Customer findById(Long id) throws CustomerIdNotFoundException;
	Customer updateCustomer(Customer customer,Long id) throws CustomerIdNotFoundException;
	void deleteCustomer(Long id);
	public List<Customer> listAllCustomers();
}
