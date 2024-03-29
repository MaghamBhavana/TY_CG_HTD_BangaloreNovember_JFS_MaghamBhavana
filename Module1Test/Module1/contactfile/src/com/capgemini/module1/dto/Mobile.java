package com.capgemini.module1.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class Mobile implements Serializable{
	private String name;
	private long number;
	private String group;
	
	@Override
	public String toString() {
		return "Mobile [name=" + name + ", number=" + number + ", group=" + group + "]";
	}
	
	
}
