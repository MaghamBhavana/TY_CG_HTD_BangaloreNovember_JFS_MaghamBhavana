package com.capgemini.linkedlist;

import java.util.LinkedList;

public class LinkedListMethod 
{
	public static void main(String[] args) {
		
		LinkedList l1 = new LinkedList();
		
		l1.add(23);
		l1.add(45);
		l1.add(67);
		l1.add(78);
		l1.add(45);
		System.out.println(l1);
		
		System.out.println("-------addFirst,addLast-----");
		l1.addFirst(19);
		l1.addLast(47);
		System.out.println(l1);
		
		System.out.println("------remove,removeFirst,removeLast-------");
		l1.remove();
		l1.removeFirst();
		l1.removeLast();
		System.out.println(l1);
		
		LinkedList l2 = new LinkedList();
		l2.add(34);
		l2.add(45);
		l2.add(47);
		l2.add(98);
		l2.add(47);
		l2.add(44);
		l2.add(47);
		System.out.println(l2);
		
		System.out.println("-----------getFirst,getLast-----");
		System.out.println(l2.getFirst());
		System.out.println(l2.getLast());
		
		System.out.println("-------removeFirstOccu,removeLastOccu--------");
		l2.removeFirstOccurrence(47);
		l2.removeLastOccurrence(47);
		System.out.println(l2);
	}
}
