package com.capgemini.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class ArrayList1 
{
	public static void main(String[] args) {
		
		ArrayList<Integer> a = new ArrayList<Integer>();
		
		a.add(12);
		a.add(32);
		a.add(35);
		a.add(65);
		a.add(98);
		System.out.println(a);
		a.remove(2);
		System.out.println(a);
		System.out.println("---------for loop---------");
		for (int i = 0; i < a.size(); i++) 
		{
			System.out.println(a.get(i));
		}
		System.out.println("-------foreach--------");
		for (Integer integer : a) 
		{
			System.out.println(integer);
		}
		System.out.println("------------Iterator----------");
		Iterator<Integer> itr = a.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
		System.out.println("-------------ListIterator---------");
		ListIterator<Integer> itr1 = a.listIterator();
		while(itr1.hasNext())
		{
			System.out.println(itr1.next());
		}
		while(itr1.hasPrevious())
		{
			System.out.println(itr1.previous());
		}
		
		ArrayList<Integer> a2 = new ArrayList<Integer>();
		a2.add(23);
		a2.add(44);
		System.out.println(a2);
		a2.remove(new Integer(23));
		System.out.println(a2);
	}

}
