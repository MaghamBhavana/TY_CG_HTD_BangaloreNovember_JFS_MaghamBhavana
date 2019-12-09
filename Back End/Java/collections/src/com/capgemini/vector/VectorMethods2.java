package com.capgemini.vector;

import java.util.Vector;

public class VectorMethods2 
{
	public static void main(String[] args) {
		
		Vector v = new Vector();
		v.addElement(22);
		v.addElement(55);
		v.addElement(45);
		v.addElement(12);
		v.add(88);
		v.add(76);
		System.out.println(v);
		v.removeElement(12);
		System.out.println(v);
		v.removeElementAt(1);
		System.out.println(v);
		
		Object o[] = new Object[v.size()];
		
		v.copyInto(o);
		for (int i = 0; i < o.length; i++) 
		{
			System.out.println(o[i]);
		}
		
		Vector v1 = new Vector();
		v1.addElement(45);
		v1.addElement(52);
		v1.addElement(12);
		System.out.println(v1);
		System.out.println(v1.size());
		System.out.println(v1.capacity());
		v1.trimToSize();
		System.out.println(v1.size());
		System.out.println(v1.capacity());
		v1.ensureCapacity(7);
		System.out.println(v1.capacity());
		v1.setSize(10);
		System.out.println(v1.size());
		System.out.println(v1.capacity());
		System.out.println(v1);
		
	}
}
