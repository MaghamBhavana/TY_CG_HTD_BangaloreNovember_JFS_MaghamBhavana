package com.capgemini.map.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMap1 
{
	public static void main(String[] args) {
		
		HashMap<Integer, String> h = new HashMap<Integer, String>();
		
		h.put(20, "Bhavana");
		h.put(4, "Ramya");
		h.put(50, "Chandrika");
		h.put(30, "Koteswararao");
		
		Set<Map.Entry<Integer,String>> s1=h.entrySet();
		
		for (Map.Entry<Integer, String> s : s1) 
		{
			System.out.println(s.getKey());
			System.out.println(s.getValue());
			System.out.println("------------");
		}
	}

}
