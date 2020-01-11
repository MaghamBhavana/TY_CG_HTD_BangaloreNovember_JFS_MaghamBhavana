package com.capgemini.module2.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="product_Info")
public class ProductInfoBean {
	@Id
	@Column
	@GeneratedValue
	private int id;
	@Column(unique=true)
	private String name;
	@Column
	private int quantity;
	@Column
	private String details;
/*	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="id",referencedColumnName="user_id")
	private UserInfoBean userBean;
	@OneToMany(cascade = CascadeType.ALL, mappedBy= "productBean")
	private List<OrderInfoBean> orderBean;*/

}
