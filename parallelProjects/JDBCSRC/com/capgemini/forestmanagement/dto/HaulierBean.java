package com.capgemini.forestmanagement.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class HaulierBean implements Serializable {
	private int haulierId;
	private String haulierName;
	private String address1;
	private String address2;
	private String town;
	private int postalcode;
	private long telephone;
	private String email;
}
