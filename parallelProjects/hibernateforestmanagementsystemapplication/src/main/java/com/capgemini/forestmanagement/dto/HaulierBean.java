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
@Table(name="haulier")
public class HaulierBean {
	@Id
	@Column
	@GeneratedValue
	private int haulierId;
	@Column(nullable=true)
	private String haulierName;
	@Column(nullable=true)
	private String address1;
	@Column
	private String address2;
	@Column
	private String town;
	@Column
	private int postalCode;
	@Column
	private long telephone;
	@Column(unique=true,nullable=false)
	private String email;
	@Exclude
	@OneToMany(cascade=CascadeType.ALL,mappedBy="haulier")
	private List<ContractBean> contracts;
	@Exclude
	@OneToMany(cascade=CascadeType.ALL,mappedBy="haulier")
	private List<OrderBean> orders;

}
