package com.capgemini.set.treeset;

import java.util.TreeSet;

public class CustomStudent 
{
	public static void main(String[] args) {
		
		TreeSet<Student> s = new TreeSet<Student>();
		s.add(new Student(22, "ramya"));
		s.add(new Student(23, "bhavana"));
		s.add(new Student(24, "balaram"));
		s.add(new Student(22, "ramya"));
		
		for (Student s1 : s) {
			System.out.println(s1);
		}
	}

}
