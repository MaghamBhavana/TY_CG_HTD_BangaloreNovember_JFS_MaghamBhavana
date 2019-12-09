package com.capgemini.collections;

import java.util.ArrayList;
import java.util.Collection;

public class Collection3 
{
	public static void main(String[] args) {
		
		
		Collection c1 = new ArrayList<>();
		c1.add(12);
		c1.add(31);
		c1.add(23);
		System.out.println(c1);
		System.out.println("-------------");
		Collection c2 = new ArrayList<>();
		c2.add(45);
		c2.add(46);
		System.out.println(c2);
		System.out.println("-------------");
		c2.addAll(c1);
		System.out.println(c2);
		System.out.println("------------");
		c2.removeAll(c1);
		System.out.println(c2);
		System.out.println("----------");
		System.out.println(c2.containsAll(c1));
		System.out.println("-------------------");
		
		Collection c3 = new ArrayList<>();
		
		c3.add(23);
		c3.add(67);
		c3.add(32);
		
		Collection c4 = new ArrayList<>();
		
		c4.add(67);
		c4.add(12);
		c4.add(78);
		
		c4.retainAll(c3);
		System.out.println(c4);
		
		c4.clear();
		System.out.println(c4);
		
		System.out.println(c1);
		
		Object o[]=c1.toArray();
		
		for(int i=0; i<o.length; i++)
		{
			System.out.println(o[i]);
		}
		
	}

}
