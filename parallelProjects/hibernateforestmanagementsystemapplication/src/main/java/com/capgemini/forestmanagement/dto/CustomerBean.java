package com.capgemini.forestmanagement.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString.Exclude;

@Data
@Entity
@Table(name="customer")
public class CustomerBean {
	@Id
	@Column
	@GeneratedValue
	private int customerId;
	@Column(nullable=false)
	private String customerName;
	@Column(nullable=false)
	private String address1;
	@Column
	private String address2;
	@Column
	private String town;
	@Column
	private int postalCode;
	@Column(unique=true,nullable=false)
	private String email;
	@Column
	private long phoneNumber;
	
	@Exclude
	@OneToMany(cascade=CascadeType.ALL,mappedBy="customer")
	private List<ContractBean> contracts;
	@Exclude
	@OneToMany(cascade=CascadeType.ALL,mappedBy="customer")
	private List<OrderBean> orders;
}
