package com.capgemini.set.hashset;

import java.util.HashSet;

public class HashSet1 
{
	public static void main(String[] args) 
	{
		HashSet<Integer> hs = new HashSet<Integer>();
		
		hs.add(23);
		hs.add(45);
		hs.add(56);
		hs.add(78);
		hs.add(null);
		hs.add(78);
		
		for (Object object : hs) {
			System.out.println(object);
		}
		
		HashSet<String> hs1 = new HashSet<String>();
		hs1.add("Bhavana");
		hs1.add("Ramya");
		
		for (String string : hs1) {
			System.out.println(string);
		}
				
		
		
	}

}
