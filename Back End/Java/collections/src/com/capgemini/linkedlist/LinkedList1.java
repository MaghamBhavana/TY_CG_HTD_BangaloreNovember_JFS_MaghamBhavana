package com.capgemini.linkedlist;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedList1 
{
	public static void main(String[] args) 
	{
		LinkedList l = new LinkedList();
		
		l.add(12);
		l.add(23);
		l.add(34);
		l.add(98);
		l.add(45);
		l.add(23);
		l.add(null);
		System.out.println(l);
		
		ListIterator itr = l.listIterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
		
		l.remove(new Integer(23));
		l.remove(null);
		System.out.println(l);
		
		System.out.println("------for each loop----------");
		
		for (Object object : l) {
			System.out.println(object);
		}
		
		System.out.println("-----------for loop-----------");
		
		for (int i = 0; i < l.size(); i++) {
			System.out.println(l.get(i));
			
		}
	}

}
