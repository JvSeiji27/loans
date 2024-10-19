package com.joaovitorseiji.loans.domain;

public class Customer {
	
	private Integer age;
	private String cpf;
	private String name;
	private Double income;
	private String location;
	
	public Customer(Integer age, String cpf, String name, Double income, String location) {
		super();
		this.age = age;
		this.cpf = cpf;
		this.name = name;
		this.income = income;
		this.location = location;
	}
	
	public boolean isIncomeEqualOrLowerThan(Double value) {
		if(income <= value) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean isIncomeBetween(Double minValue, Double maxValue) {
		if(income >= minValue && income <= maxValue) {
			return true;
		}else {
			return false;
		}
	}	
	
	public boolean isAgeLowerThan(Integer value) {
		if(age < value) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean isFromLocation(String location) {
		if(this.location.equalsIgnoreCase(location)) {
			return true;
		}
		return false;
	}
	
	public boolean isIncomeEqualOrHigher(Double value) {
		if(income >= value) {
			return true;
		}else
			return false;
	}
	
}
