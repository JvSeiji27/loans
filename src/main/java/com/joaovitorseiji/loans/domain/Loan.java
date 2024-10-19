package com.joaovitorseiji.loans.domain;

public class Loan {
	private LoanType type;
	private Double interestRate;
	private Customer customer;
	
	public Loan (Customer customer) {
		this.customer = customer;
	}
	
	public boolean isPersonalLoanAvailable() {
			return basicValidation();
	}
	
	public boolean isConsignmentLoanAvailable() {
		if(customer.isIncomeEqualOrHigher(5000.0)) {
			return true;
		}
		return false;
	}
	
	public boolean isGuaranteedLoanAvailable() {
		return basicValidation();
	}
	
	public double getPersonalLoanInterestRate() {
		if(isPersonalLoanAvailable()) {
			return 4.0;
		}else {
			throw new LoanNotAvailableException();
		}
	}
	
	public double getConsignmentLoanInterestRate() {
		if(isConsignmentLoanAvailable()) {
			return 2.0;
		}
		throw new LoanNotAvailableException();
	}
	
	public double getGuaranteedLoanInterestRate() {
		if(isGuaranteedLoanAvailable()) {
			return 3.0;
		}else {
			throw new LoanNotAvailableException();
			}
	}
	
	public boolean basicValidation() {
		if(customer.isIncomeEqualOrLowerThan(3000.0)){
			return true;
		}
		if(customer.isFromLocation("SP") && customer.isIncomeBetween(3000.0, 5000.0) && customer.isAgeLowerThan(30)) {
			return true;
		}
		return false;
	}
	
}
