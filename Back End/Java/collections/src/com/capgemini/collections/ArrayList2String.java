package com.capgemini.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class ArrayList2String 
{
	public static void main(String[] args) {
		
		ArrayList<String> a = new ArrayList<String>();
		a.add("bhavana");
		a.add("ramya");
		a.add("chandrika");
		a.add("koteswararao");
		a.add("balaram");
		a.add("gowthami");
		System.out.println(a);
		a.remove(4);
		System.out.println(a);
		
		ArrayList<String> a1 = new ArrayList<String>();
		a1.add("teja");
		a1.add("megha");
		a1.add("sandhya");
		a1.add("kalpana");
		a1.add("chandu");
		System.out.println(a1);
		
		a1.remove(1);
		System.out.println(a1);
		System.out.println("-----for loop---------");
		for (int i = 0; i < a1.size(); i++)
		{
			System.out.println(a1.get(i));
		}
		System.out.println("-----------for each loop------------");
		for (String string : a1)
		{
			System.out.println(string);
		}
		System.out.println("-----------iterator----------------");
		Iterator<String> i= a.iterator();
		while(i.hasNext())
		{
			System.out.println(i.next());
		}
		System.out.println("---------------list iterator--------");
		ListIterator<String> itr = a.listIterator(a.size());
		while(itr.hasPrevious())
		{
			System.out.println(itr.previous());
		}
		System.out.println("---------combination of Next,Previous------------");
		
		ListIterator<String> itr1 = a.listIterator();
		System.out.println("------forward---------");
		while(itr1.hasNext())
		{
			System.out.println(itr1.next());
		}
		System.out.println("----------backward-----------");
		while(itr1.hasPrevious())
		{
			System.out.println(itr1.previous());
		}
	}
	
	

}
