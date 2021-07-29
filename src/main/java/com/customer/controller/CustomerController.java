package com.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cbre.logger.utils.LoggerUtils;
import com.customer.model.Customer;
import com.customer.service.CustomerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/customer")
@Log4j2
public class CustomerController {

	private CustomerService customerService;

	private ObjectMapper objectMapper;

	@Autowired
	public CustomerController(CustomerService customerService, ObjectMapper objectMapper) {
		super();
		this.customerService = customerService;
		this.objectMapper = objectMapper;
	}

	@PostMapping("/save")
	public boolean save(@RequestBody Customer customer) throws JsonProcessingException, Exception {

		
		  LoggerUtils.addLogValue("Company", "CBRE");
		  LoggerUtils.addLogValue("USER_EMAIL", "vishal.palla@cbre.com");
		  LoggerUtils.addJsonToLog(objectMapper.writeValueAsString(customer));
//		  log.info("In controlle!!");
		 
//		int a = 2/0;
		return customerService.save(customer);
	}

	@PostMapping("/saveAll")
	public boolean saveAll(@RequestBody List<Customer> customer) {
		return customerService.saveAll(customer);
	}

	@GetMapping("/getAllCustomers")
	public List<Customer> getAllCustomers() {
		LoggerUtils.addLogValue("USER_EMAIL", "vishal.palla@cbre.com");
		return customerService.getAllCustomers();
	}

}
