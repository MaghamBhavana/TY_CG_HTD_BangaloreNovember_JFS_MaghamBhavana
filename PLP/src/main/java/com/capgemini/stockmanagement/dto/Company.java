package com.capgemini.stockmanagement.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "companies_info")
public class Company {
	@Id
	@Column
	@GeneratedValue
	private int companyId;
	@Column(nullable = false,unique=true)
	private String companyName;
	@Column(nullable = false)
	private int stockAvailability;
	@Column(nullable = false)
	private String totalQuantity;
	@Column(nullable=false)
	private double bidPrice;
	@Column(nullable = false)
	private String maxStockAmount;
	@Column(nullable=false)
	private double maxStockQuantity;
}
