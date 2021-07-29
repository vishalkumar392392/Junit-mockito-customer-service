package com.customer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.customer.model.Customer;

@Service
public interface CustomerService {

	boolean save(Customer customer);

	boolean saveAll(List<Customer> customer);

	List<Customer> getAllCustomers();

	String getDetails();
}
