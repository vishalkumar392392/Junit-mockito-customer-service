package com.customer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.service.CustomerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/details")
@RequiredArgsConstructor
public class DetailsController {
	
	private final CustomerService customerService;
	
	@GetMapping("/details")
	public String getDetails() {
		return customerService.getDetails();
	}

}
