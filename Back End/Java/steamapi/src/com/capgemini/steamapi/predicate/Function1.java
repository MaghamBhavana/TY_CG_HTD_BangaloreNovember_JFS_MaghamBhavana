package com.capgemini.steamapi.predicate;

import java.util.function.Function;

public class Function1 {
	public static void main(String[] args) {
		
		Function<Integer,Integer> f1 = i -> i*100;
		
		int a = f1.apply(44);
		System.out.println(a);
	}

}
