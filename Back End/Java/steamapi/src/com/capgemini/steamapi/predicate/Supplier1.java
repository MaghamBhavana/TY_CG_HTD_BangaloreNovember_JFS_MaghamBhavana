package com.capgemini.steamapi.predicate;

import java.util.function.Supplier;

public class Supplier1 {
	public static void main(String[] args) {
		
		Supplier<Person> s = () -> new Person(22,"Ramya");
		System.out.println(s.get().getAge());
		System.out.println(s.get().getName());
		
	}

}
