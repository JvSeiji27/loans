package com.joaovitorseiji.loans.dto;

import com.joaovitorseiji.loans.domain.LoanType;

public record LoanResponse(LoanType type, Double interestRate) {

}
