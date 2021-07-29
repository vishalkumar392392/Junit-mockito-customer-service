package com.customer.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.Validator;

import com.customer.utils.MockProviderUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestCustomerController {

	private CustomerController controller;

	private MockMvc mvc;

	@BeforeEach
	public void init() {
		final Validator mockValidator = Mockito.mock(Validator.class);
		controller = new CustomerController(MockProviderUtils.getCustomerService(),
				MockProviderUtils.getObjectMapper());
		mvc = MockMvcBuilders.standaloneSetup(controller).setValidator(mockValidator).build();
	}

	@Test
	public void testSave() throws JsonProcessingException, Exception {
		ObjectMapper obj = new ObjectMapper();
		mvc.perform(MockMvcRequestBuilders.post("/customer/save/").contentType(MediaType.APPLICATION_JSON)
				.content(obj.writeValueAsString(MockProviderUtils.getCustomer())))
				.andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
	}

	@Test
	public void testgetAllCustomers() throws JsonProcessingException, Exception {
		mvc.perform(MockMvcRequestBuilders.get("/customer/getAllCustomers/"))
				.andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
	}
	
	@Test
	public void testgetAllCustomers_Exception() throws JsonProcessingException, Exception {
		mvc.perform(MockMvcRequestBuilders.get("/customer/getAllCustomer/"))
				.andExpect(MockMvcResultMatchers.status().is4xxClientError());
	}
}
