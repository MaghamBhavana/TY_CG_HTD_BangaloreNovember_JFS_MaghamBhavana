package com.capgemini.set.treeset;

import java.util.TreeSet;

public class TreeSet1 
{
	public static void main(String[] args) {
		
		TreeSet t1 = new TreeSet();
		t1.add(23);
		t1.add(97);
		t1.add(97);
		t1.add(44);
		t1.add(55);
		t1.add("njanjna");//Exception because Tree set doesn't allow the Heterogenous type.
		
		System.out.println(t1);
		for (Object object : t1) {
			System.out.println(object);
		}
		
		t1.remove(55);
		System.out.println(t1);
		
		
	}

}
