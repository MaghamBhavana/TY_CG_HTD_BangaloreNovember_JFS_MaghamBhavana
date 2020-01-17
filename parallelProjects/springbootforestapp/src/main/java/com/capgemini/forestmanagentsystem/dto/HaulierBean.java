package com.capgemini.forestmanagentsystem.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="haulier")
public class HaulierBean {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int haulierId;
	@Column(nullable=false,unique=true)
	private String haulierName;
	@Column(nullable=false)
	private String address1;
	@Column
	private String address2;
	@Column
	private String town;
	@Column
	private int postalCode;
	@Column(nullable=false)
	private long telephone;
	@Column(nullable=false)
	private String email;

}
