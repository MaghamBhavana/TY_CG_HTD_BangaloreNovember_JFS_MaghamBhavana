package com.capgemini.set.hashset;

import java.util.HashSet;

public class CustonPerson {
	
	public static void main(String[] args) {
		
		HashSet<Person> h1= new  HashSet<Person>();
		
		
		h1.add(new Person(22, "bhavana"));
		h1.add(new Person(23, "ramya"));
		h1.add(new Person(25, "Nani"));
		h1.add(new Person(23, "ramya"));
		
		for (Person s : h1) {
			System.out.println(s.name+" your age is "+s.age );
		}
	}

}
