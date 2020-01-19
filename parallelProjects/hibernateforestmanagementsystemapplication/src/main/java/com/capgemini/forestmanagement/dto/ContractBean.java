package com.capgemini.forestmanagement.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="contract")
public class ContractBean {
	@Id
	@Column
	@GeneratedValue
	private int contractNo;
	@Column
	private String deliveryDate;
	@Column
	private String deliveryDay;
	@Column
	private int quantity;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="customerId")
	private CustomerBean customer;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="haulierId")
	private HaulierBean haulier;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="productId")
	private ProductBean product;
	
}
