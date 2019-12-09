package com.capgemini.vector;

import java.util.Vector;

public class Vector1 
{
	public static void main(String[] args) {
		
		Vector v = new Vector();
		
		v.add(45);
		v.add(34);
		v.add(55);
		v.add(56);
		v.add(76);
		System.out.println(v);
		v.remove(new Integer(55));
		System.out.println(v);
		
		System.out.println("-------for loop------------");
		for (int i = 0; i < v.size(); i++) {
			System.out.println(v.get(i));
		}
		
		System.out.println("--------for each loop---------");
		for (Object object : v) {
			System.out.println(object);
		}
	}

}
