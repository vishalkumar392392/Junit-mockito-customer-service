package com.customer.service;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import com.customer.model.Customer;
import com.customer.service.impl.CustomerServiceImpl;
import com.customer.utils.MockProviderUtils;

public class TestCustomerService {
	
	@InjectMocks
	private CustomerService service;
	
	@BeforeEach
	public void init() {
		service = new CustomerServiceImpl(MockProviderUtils.getCustomerRepository(),
				MockProviderUtils.getObjectMapper());
	}
	
	@Test
	public void testGetAllCustomer() {
		List<Customer> customers = service.getAllCustomers();
		Assertions.assertEquals(MockProviderUtils.getListCustomers(), customers);
	}

}
