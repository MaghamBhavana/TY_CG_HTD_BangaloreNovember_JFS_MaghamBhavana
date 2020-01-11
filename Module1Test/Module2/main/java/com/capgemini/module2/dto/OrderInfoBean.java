package com.capgemini.module2.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="order_Info")
public class OrderInfoBean {
	
	@Id
	@Column
	@GeneratedValue
	private int id;
/*	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="id",referencedColumnName="user_id")
	private UserInfoBean userBean;
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="id",referencedColumnName="product_id")
	private ProductInfoBean productBean;
	*/

}
