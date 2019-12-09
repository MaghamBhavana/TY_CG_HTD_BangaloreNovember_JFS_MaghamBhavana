package com.capgemini.map.linkedhashmap;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LinkedHashMap1 {
	public static void main(String[] args) {
		
		LinkedHashMap<String,Integer> l =new LinkedHashMap<String,Integer>();
		
		l.put("Vijayawada", 522909);
		l.put("Amaravathi", 522486);
		l.put("Guntur", 522309);
		l.put("Vizag", 522786);
		l.put("Vij", 522486);
		
		System.out.println(l.size());
		System.out.println(l.containsKey("Guntur"));
		System.out.println(l.containsValue(522409));
		System.out.println(l.isEmpty());
		System.out.println(l.replace("Guntur", 522309, 522306));
		l.remove("Vizag");
		
		Set<Map.Entry<String,Integer>> s =l.entrySet();
		
		for (Map.Entry<String, Integer> e : s) {
			System.out.println(e.getKey());
			System.out.println(e.getValue());
			System.out.println("------------------");
			
		}
	}

}
