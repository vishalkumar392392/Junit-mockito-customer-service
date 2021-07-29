package com.customer.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.model.Customer;
import com.customer.repository.CustomerRepository;
import com.customer.service.CustomerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.tools.sjavac.Log;

import lombok.extern.log4j.Log4j2;

@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository customerRepository;

	private ObjectMapper objectMapper;
	
	private static Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository, ObjectMapper objectMapper) {
		super();
		this.customerRepository = customerRepository;
		this.objectMapper = objectMapper;
	}

	@Override
	public boolean save(Customer customer) {
		logger.info("in Service!!");
		return customerRepository.save(customer);
	}

	@Override
	public boolean saveAll(List<Customer> list) {
		return customerRepository.saveAll(list);
	}

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> cus = customerRepository.getCustomers();
		try {
			objectMapper.writeValueAsString(cus);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return cus;
	}

	@Override
	public String getDetails() {
		return "Details....";
	}

}
