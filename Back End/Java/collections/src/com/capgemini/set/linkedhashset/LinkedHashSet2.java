package com.capgemini.set.linkedhashset;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkedHashSet2 
{
	public static void main(String[] args) {
		
		LinkedHashSet<Integer> i =new LinkedHashSet<Integer>();
		i.add(12);
		i.add(34);
		i.add(34);
		i.add(45);
		i.add(67);
		i.add(null);
		
		System.out.println(i);
		
		Iterator<Integer> itr = i.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
		
	}

}
