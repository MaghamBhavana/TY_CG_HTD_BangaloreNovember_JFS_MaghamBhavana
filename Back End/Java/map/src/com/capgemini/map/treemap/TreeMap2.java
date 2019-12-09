package com.capgemini.map.treemap;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMap2 {
	public static void main(String[] args) {
		SortingAge s1=new SortingAge();
		TreeMap<Student, String> t = new TreeMap<Student, String>(s1);
		
		t.put(new Student("Bhavana", 15), "10th Standard");
		t.put(new Student("Ramya", 14), "9th Standard");
		t.put(new Student("Balaram", 20), "15th Standard");
		
		Set<Map.Entry<Student, String>> s=t.entrySet();
		
		for (Map.Entry<Student, String> entry : s) {
			System.out.println(entry);
			
		}
	}

}
