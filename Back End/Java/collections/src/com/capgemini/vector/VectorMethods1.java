package com.capgemini.vector;

import java.util.Vector;

public class VectorMethods1 
{
	public static void main(String[] args) {
		
		Vector v = new Vector();
		System.out.println(v.size());
		System.out.println(v.capacity());
		v.add(23);
		v.add(56);
		v.add(78);
		v.add(100);
		System.out.println(v);
		System.out.println(v.size());
		System.out.println(v.capacity());
		v.trimToSize();
		System.out.println(v.size());
		System.out.println(v.capacity());
		v.setSize(10);
		System.out.println(v.size());
		System.out.println(v);
		v.add(200);
		//v.trimToSize();
		System.out.println(v.size());
		System.out.println(v.capacity());
		System.out.println(v);
		v.set(5, 600);
		System.out.println(v);
		v.removeAllElements();
		System.out.println(v);
	}

}
