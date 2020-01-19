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
@Table(name="orders")
public class OrderBean {
	@Id
	@Column
	@GeneratedValue
	private int orderNo;
	@Column
	private int quantity;
	@Column
	private String deliveryDay;
	@Column
	private String deliveryDate;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="customerId")
	private CustomerBean customer;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="productId")
	private ProductBean product;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="haulierId")
	private HaulierBean haulier;
}
