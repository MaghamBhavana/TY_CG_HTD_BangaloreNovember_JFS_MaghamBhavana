package com.capgemini.set.hashset;

import java.util.HashSet;

public class CustomHashSet 
{
	public static void main(String[] args) 
	{
		HashSet<Student> h1 = new HashSet<Student>();
		h1.add(new Student(22, "bhavana"));
		h1.add(new Student(23, "ramya"));
		h1.add(new Student(25, "Nani"));
		h1.add(new Student(23, "ramya"));
		
		for (Student student : h1) {
			System.out.println(student.name+" your age is "+student.age );
		}
		
		
	}

}
