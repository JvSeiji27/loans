package com.joaovitorseiji.loans.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.joaovitorseiji.loans.dto.CustomerLoanRequest;
import com.joaovitorseiji.loans.dto.CustomerLoanResponse;
import com.joaovitorseiji.loans.service.LoanService;

import jakarta.validation.Valid;

@RestController
public class LoanController{
	
	@Autowired
	LoanService service;
	
	@PostMapping(value = "/customer-loans")
	public ResponseEntity<CustomerLoanResponse> customerLoans(@RequestBody @Valid CustomerLoanRequest dto){
		
		var loanResponse = service.checkLoanAvailability(dto);
		return ResponseEntity.ok(loanResponse);
	}
}
