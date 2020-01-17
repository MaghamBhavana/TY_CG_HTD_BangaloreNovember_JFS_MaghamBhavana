package com.capgemini.springrestforestapp.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="orders")
public class OrderBean {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int orderNo;
	@Column(nullable=false,unique=true)
	private int customerId;
	@Column(nullable=false)
	private int productId;
	@Column
	private int quantity;
	@Column
	private String deliveryDay;
	@Column(nullable=false)
	private String deliveryDate;
	@Column
	private int haulierId;

}
