package com.capgemini.collections;

import java.util.ArrayList;
import java.util.Collection;

public class Collection1 
{
	public static void main(String[] args) {
		
		Collection c = new ArrayList();
		
		//add the elements into the collection
		c.add(11);
		System.out.println(c);
		
		//remove the objects into the collection
		c.remove(11);
		System.out.println(c);
		c.add(32);
		System.out.println(c.isEmpty());//checking whether the collection is empty or not
		System.out.println(c.contains(32));//searching the object present or not
		System.out.println(c.size());//it gets the size of the collection
	}

}
