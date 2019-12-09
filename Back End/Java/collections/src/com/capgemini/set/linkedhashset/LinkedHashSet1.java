package com.capgemini.set.linkedhashset;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkedHashSet1 
{
	public static void main(String[] args) {
		
		LinkedHashSet l = new LinkedHashSet();
		l.add(12);
		l.add(23);
		l.add(45);
		l.add(45);
		l.add(null);
		l.add(null);
		
		System.out.println(l);
		
		Iterator itr = l.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
 	}

}
