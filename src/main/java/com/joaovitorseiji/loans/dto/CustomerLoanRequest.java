package com.joaovitorseiji.loans.dto;
import org.hibernate.validator.constraints.br.CPF;

import com.joaovitorseiji.loans.domain.Customer;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CustomerLoanRequest(@NotNull @Min(value = 18)Integer age,
		@NotBlank @CPF String cpf,
		@NotBlank String name,
		@NotNull @Min(value = 1000) Double income,
		@NotBlank String location) {
	
	public Customer toCustomer() {
		return new Customer(age, cpf, name, income, location);
	}
	

}
