package com.capgemini.module2.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="User_Info")
public class UserInfoBean {
	@Id
	@Column
	@GeneratedValue
	private int id;
	@Column
	private String name;
	@Column(unique=true)
	private String email;
	@Column
	private String password;
	/*@OneToMany(cascade = CascadeType.ALL, mappedBy= "userBean")
	private List<ProductInfoBean> productBean;
	@OneToMany(cascade = CascadeType.ALL, mappedBy= "userBean")
	private List<OrderInfoBean> orderBean;*/
}
