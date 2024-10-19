package com.joaovitorseiji.loans.dto;

import java.util.List;

public record CustomerLoanResponse(String costumer, List <LoanResponse> loans) {

}
