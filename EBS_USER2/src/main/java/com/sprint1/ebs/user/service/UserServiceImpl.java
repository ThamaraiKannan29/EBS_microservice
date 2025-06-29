package com.sprint1.ebs.user.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sprint1.ebs.user.entities.Customer;
import com.sprint1.ebs.user.entities.User;
import com.sprint1.ebs.user.exception.CustomerIdNotFoundException;
import com.sprint1.ebs.user.repo.CustomerRepository;
import com.sprint1.ebs.user.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository repo;

	@Autowired
	private CustomerRepository repo2;
	
	@Override
	public User addAdmin(User u) {
		
		return repo.save(u);
	}

	@Override
	public Customer findById(Long id) throws CustomerIdNotFoundException{
		
		return (Customer) repo2.findById(id).orElseThrow(CustomerIdNotFoundException::new);
	}

	@Override
	public void deleteCustomer(Long id) {
		 repo2.deleteById(id);
	}

	@Override
	public List<Customer> listAllCustomers() {
		return repo2.findAll();
	}

	@Override
	public Customer addCustomer(Customer customer) {
		return repo2.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer, Long id) throws CustomerIdNotFoundException {
		Customer cus = (Customer)repo.findById(id).orElseThrow(CustomerIdNotFoundException::new);
		cus.setCustName(customer.getCustName());
		cus.setPhoneNumber(customer.getPhoneNumber());
		cus.setCustAddress(customer.getCustAddress());
		return repo.save(cus);
	}

}
