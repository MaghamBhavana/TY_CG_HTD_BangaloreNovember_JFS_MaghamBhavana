package com.capgemini.collections;

import java.util.ArrayList;
import java.util.List;

public class List1 
{
	public static void main(String[] args) {
		
		List l1=new ArrayList<>();
		
		
		l1.add(0,"rams");
		l1.add(1,"bhavs");
		l1.add(2,"teja");
		l1.add(3,"balaram");
		l1.add(1, "gowmi");
		l1.add(4,"teja");
		System.out.println(l1);
		
		l1.remove(1);
		System.out.println(l1);
		
		System.out.println(l1.indexOf("bhavs"));
		System.out.println(l1.lastIndexOf("teja"));
		System.out.println(l1.get(4));
		                                                                           
		List l2=new ArrayList<>();
		
		l2.add(0,"rams");
		l2.add(1,"bhavs");
		l2.add(2,"teja");
		
		l1.addAll(3, l2);
		System.out.println(l1);
		
		l1.set(0, "chandrika");
		System.out.println(l1);
		
		List l3 = l2.subList(0, 2);
		System.out.println(l3);
		
	}

}
