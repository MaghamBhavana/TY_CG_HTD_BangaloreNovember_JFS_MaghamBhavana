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
@Table(name="product")
public class ProductBean {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int productId;
	@Column(nullable=false,unique=true)
	private String productName;
	@Column(nullable=false)
	private double cost;
}
