package com.customer.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.customer.model.Customer;

import lombok.extern.slf4j.Slf4j;

@Component
public class CustomerRepository {

	private List<Customer> customers = new ArrayList<>();

	public List<Customer> getCustomers() {
		return customers;
	}

	public boolean save(Customer customer) {
		return customers.add(customer);
	}

	public boolean saveAll(List<Customer> list) {
		return customers.addAll(list);
	}
}
