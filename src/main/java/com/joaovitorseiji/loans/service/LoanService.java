package com.joaovitorseiji.loans.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.joaovitorseiji.loans.domain.Loan;
import com.joaovitorseiji.loans.domain.LoanType;
import com.joaovitorseiji.loans.dto.CustomerLoanRequest;
import com.joaovitorseiji.loans.dto.CustomerLoanResponse;
import com.joaovitorseiji.loans.dto.LoanResponse;

@Service
public class LoanService {
	public CustomerLoanResponse checkLoanAvailability(CustomerLoanRequest request) {
		var customer = request.toCustomer();
		var loan = new Loan(customer);
		
		List<LoanResponse> loans = new ArrayList<>();
		
		if(loan.isPersonalLoanAvailable()) {
			loans.add(new LoanResponse(LoanType.PERSONAL, loan.getPersonalLoanInterestRate()));
		}
		
		if(loan.isGuaranteedLoanAvailable()) {
			loans.add(new LoanResponse(LoanType.GUARANTEED, loan.getGuaranteedLoanInterestRate()));
		}
		
		if(loan.isConsignmentLoanAvailable()) {
			loans.add(new LoanResponse(LoanType.CONSIGNMENT, loan.getConsignmentLoanInterestRate()));
		}
		
		
		return new CustomerLoanResponse(request.name(), loans);
		
	}
}
