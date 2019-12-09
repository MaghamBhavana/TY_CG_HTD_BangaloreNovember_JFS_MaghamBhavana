package com.capgemini.map.linkedhashmap;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LinkedHashMap2 {
	
	public static void main(String[] args) {
		
		LinkedHashMap<Integer, Employee> l = new LinkedHashMap<Integer, Employee>();
		l.put(22, new Employee(230000, "Bhavana"));
		l.put(28, new Employee(400000, "Ramya"));
		l.put(44, new Employee(30000, "Chandrika"));
		l.put(21, new Employee(1000000, "Koteswararao"));
		
		Set<Map.Entry<Integer,Employee>> s = l.entrySet();
		
		for (Map.Entry<Integer, Employee> e : s) {
			System.out.println(e.getKey());
			System.out.println(e.getValue());
			
		}
		
		System.out.println(l.containsKey(44));
		System.out.println(l.containsValue(new Employee(30000,"Chandrika")));
	}

}
