package com.capgemini.steamapi.predicate;

import java.util.function.Consumer;

public class Consumer1 {
	public static void main(String[] args) {
		
	Consumer<Person> c = j -> {
		
		System.out.println(j.getAge());
		System.out.println(j.getName());
	};
	
	Person p = new Person(22,"Ramya");
	c.accept(p);
	}
}
