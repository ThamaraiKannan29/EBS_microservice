package com.sprint1.ebs.user.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.sprint1.ebs.user.entities.Customer;


public interface CustomerRepository extends JpaRepository<Customer,Long>
{

}
