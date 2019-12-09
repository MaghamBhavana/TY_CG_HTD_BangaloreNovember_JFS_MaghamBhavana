package com.capgemini.collections;

import java.util.ArrayList;
import java.util.Collection;

public class Collection2 
{
	public static void main(String[] args) {
		
		Collection c  = new ArrayList();
		
		c.add("bhavana");
		c.add("ramya");
		c.add("koteswararao");
		c.add("Chandrika");
		c.add("balaram");
		
		System.out.println(c);
		System.out.println(c.size());
		System.out.println(c.isEmpty());
		System.out.println(c.contains("ramya"));
		c.remove("balaram");
		System.out.println(c);
				
	}

}
