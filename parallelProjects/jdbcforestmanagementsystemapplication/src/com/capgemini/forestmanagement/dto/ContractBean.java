package com.capgemini.forestmanagement.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class ContractBean implements Serializable{
	private int contractNo;
	private int customerId;
	private int productId;
	private int haulierId;
	private String deliveryDate;
	private String deliveryDay;
	private int quantity;
	
}
