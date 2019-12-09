package com.capgemini.map.hashmap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMap2 {
	public static void main(String[] args) {
		
		HashMap<Integer, Student> h = new HashMap<Integer, Student>();
		
		h.put(8, new Student(22, "Bhavana"));
		h.put(5, new Student(21, "Ramya"));
		h.put(10, new Student(39, "Chandrika"));
		h.put(2, new Student(55, "Koteswararao"));
		
		Set<Map.Entry<Integer,Student>> s = h.entrySet();
		
		Collection<Student> c=h.values();
		for (Student e : c) 
		{
			System.out.println(e);
		}
		Set<Integer> s1 =h.keySet();
		for(Integer e2 : s1)
		{
			System.out.println(e2);
		}
		System.out.println(h.containsKey(5));
		System.out.println(h.containsValue(new Student(21, "Ramya")));
	}

}
