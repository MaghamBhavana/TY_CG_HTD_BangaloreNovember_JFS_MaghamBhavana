package com.capgemini.forestmanagement.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class OrderBean implements Serializable {
	
	private int orderNo;
	private int customerId;
	private int productId;
	private int haulierId;
	private String deliveryDate;
	private String deliveryDay;
	private int quantity;
	

}
