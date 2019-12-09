package com.capgemini.map.treemap;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapStudent {
	public static void main(String[] args) {
		
		ArrayList<Student> l = new ArrayList<Student>();
		l.add(new Student("Bhavana", 7));
		l.add(new Student("Ramya", 6));
		l.add(new Student("Balaram", 6));
		

		ArrayList<Student> l1 = new ArrayList<Student>();
		l1.add(new Student("Priya", 9));
		l1.add(new Student("Ramu", 10));
		l1.add(new Student("Balu", 8));
		
		TreeMap<String, ArrayList<Student>> t = new TreeMap<String, ArrayList<Student>>();
		
		t.put("2nd Stand", l);
		t.put("4th stand", l1);
		
		Set<Map.Entry<String, ArrayList<Student>>> s=t.entrySet();
		
		for (Map.Entry<String, ArrayList<Student>> e : s) {
			System.out.println(e.getKey());
			System.out.println(e.getValue());
		}
		
		System.out.println("Students List in 4th Standard = "+t.get("4th stand"));
	}
}
