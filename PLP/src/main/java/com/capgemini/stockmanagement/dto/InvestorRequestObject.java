package com.capgemini.stockmanagement.dto;

import lombok.Data;

@Data
public class InvestorRequestObject {

	private int userId;
	private int companyId;
	private int totalSharesTransacted;
	private double totalAmount;
}
