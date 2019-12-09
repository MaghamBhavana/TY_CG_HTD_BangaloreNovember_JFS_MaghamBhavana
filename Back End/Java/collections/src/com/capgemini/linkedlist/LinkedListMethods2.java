package com.capgemini.linkedlist;

import java.util.LinkedList;

public class LinkedListMethods2 
{
	public static void main(String[] args) {
		
		LinkedList l1 = new LinkedList();
		
		l1.add(24);
		l1.add(25);
		l1.add(26);
		l1.add(27);
		l1.add(28);
		l1.add(29);
		System.out.println(l1);
		
		System.out.println("------peek,peekFisrt,peekLast-------");
		System.out.println(l1.peek());
		System.out.println(l1.peekFirst());
		System.out.println(l1.peekLast());
		
		System.out.println("----------poll,pollFirst,pollLast------");
		System.out.println(l1.poll());
		System.out.println(l1);
		System.out.println(l1.pollFirst());
		System.out.println(l1);
		System.out.println(l1.pollLast());
		System.out.println(l1);
		
		System.out.println("-----------offer,offerFirst,offerLast-------");
		l1.offer(34);
		l1.offerFirst(99);
		l1.offerLast(87);
		System.out.println(l1);
		System.out.println("------push,pop,element-----------");
		l1.push(22);
		System.out.println(l1);
		l1.pop();
		System.out.println(l1);
		System.out.println(l1.element());
		
		
	}

}
