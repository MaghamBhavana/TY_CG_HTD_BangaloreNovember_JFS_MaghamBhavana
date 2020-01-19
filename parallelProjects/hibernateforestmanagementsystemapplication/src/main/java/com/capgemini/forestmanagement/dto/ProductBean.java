package com.capgemini.forestmanagement.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString.Exclude;

@Data
@Entity
@Table(name="product")
public class ProductBean {
	@Id
	@Column
	@GeneratedValue
	private int productId;
	@Column(unique=true,nullable=false)
	private String productName;
	@Column(unique=true,nullable=false)
	private double cost;
	@Exclude
	@OneToOne(cascade=CascadeType.ALL,mappedBy="product")
	private OrderBean orderNo;
	@Exclude
	@OneToOne(cascade=CascadeType.ALL,mappedBy="product")
	private ContractBean contractNo;
}
