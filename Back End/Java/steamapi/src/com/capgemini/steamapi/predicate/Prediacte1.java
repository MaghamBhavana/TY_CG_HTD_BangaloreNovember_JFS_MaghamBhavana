package com.capgemini.steamapi.predicate;

import java.util.function.Predicate;

public class Prediacte1 {
	public static void main(String[] args) {
		
		Predicate<Integer> p = i -> i%2 == 0;
		
		boolean b = p.test(12);
		System.out.println(b);
		System.out.println(p.test(33));
	}

}
