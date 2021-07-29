package com.customer.utils;

import java.util.ArrayList;
import java.util.List;

import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import com.customer.model.Customer;
import com.customer.repository.CustomerRepository;
import com.customer.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MockProviderUtils {

	public static CustomerService getCustomerService() {

		CustomerService customerService = Mockito.mock(CustomerService.class);
		Mockito.when(customerService.save(ArgumentMatchers.any(Customer.class))).thenReturn(true);
		Mockito.when(customerService.getAllCustomers()).thenReturn(getListCustomers());
		return customerService;
	}

	public static List<Customer> getListCustomers() {

		List<Customer> list = new ArrayList<>();
		Customer customer = new Customer();
		customer.setEmail("vishal@cbre.com");
		customer.setGender("MALE");
		customer.setName("vishal");
		list.add(customer);
		return list;
	}

	public static ObjectMapper getObjectMapper() {
		ObjectMapper mapper = Mockito.mock(ObjectMapper.class);
		return mapper;
	}

	public static Customer getCustomer() {
		Customer customer = new Customer();
		customer.setEmail("vishal@cbre.com");
		customer.setGender("MALE");
		customer.setName("vishal");
		return customer;
	}
	
	public static CustomerRepository getCustomerRepository() {
		CustomerRepository repo = Mockito.mock(CustomerRepository.class);
		Mockito.when(repo.getCustomers()).thenReturn(getListCustomers());
		return repo;
	}
}
