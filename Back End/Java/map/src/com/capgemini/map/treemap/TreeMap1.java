package com.capgemini.map.treemap;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMap1 {
	public static void main(String[] args) {
		
		TreeMap<Integer, String> t = new TreeMap<Integer, String>();
		t.put(222, "Bhavana");
		t.put(1111, "Ramya");
		t.put(777, "Chandrika");
		t.put(111, "Koteswararao");
		t.put(444, "Priya");
		
		System.out.println(t.containsKey(1111));
		System.out.println(t.containsValue("Ramya"));
		System.out.println(t.isEmpty());
		System.out.println(t.get(222));
		System.out.println(t.values());
		System.out.println(t.keySet());
		t.remove(444);
		
		Set<Map.Entry<Integer,String>> s=t.entrySet();
		for (Map.Entry<Integer, String> entry : s) {
			System.out.println(entry);
		}
	}
}
