package com.capgemini.steamapi.predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class GroupTheArrayListEvenOdd {
	
	public static void main(String[] args) {
		
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(22);
		a.add(33);
		a.add(11);
		a.add(44);
		a.add(55);
		a.add(66);
		a.add(77);
		
		List<Integer> l = a.stream().filter(i -> i%2==0).collect(Collectors.toList());
		System.out.println(l);
		
		List<Integer> l1 = a.stream().filter(i -> i%2!=0).collect(Collectors.toList());
		System.out.println(l1);
		
		List<Integer> l2 = a.stream().map(i -> i*100).collect(Collectors.toList());
		System.out.println(l2);
		
		Optional<Integer> a1= a.stream().max((i,j) -> i.compareTo(j));
		System.out.println(a1);
		
		System.out.println(a.stream().count());
	}

}
