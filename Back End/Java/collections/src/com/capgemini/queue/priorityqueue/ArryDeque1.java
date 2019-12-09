package com.capgemini.queue.priorityqueue;

import java.util.ArrayDeque;

public class ArryDeque1 
{
	public static void main(String[] args) {
		
		ArrayDeque<Integer> a = new ArrayDeque<Integer>();
		a.add(23);
		a.add(2);
		a.add(23);
		a.add(33);
		a.addFirst(66);
		a.addLast(22);
		System.out.println(a);
		System.out.println(a.getFirst());
		System.out.println(a.getLast());
		a.remove(23);
		System.out.println(a);
		a.removeFirst();
		a.removeLast();
		System.out.println(a);
		a.add(44);
		a.add(66);
		a.add(66);
		a.add(88);
		a.add(200);
		System.out.println(a);
		a.removeFirstOccurrence(66);
		a.removeLastOccurrence(66);
		System.out.println(a);
		System.out.println(a.peek());
		System.out.println(a.peekFirst());
		System.out.println(a.peekLast());
		a.poll();
		a.pollFirst();
		a.pollLast();
		System.out.println(a);
		a.offer(10);
		a.offerFirst(22);
		a.offerLast(11);
		System.out.println(a);
		a.push(12);
		System.out.println(a);
		a.pop();
		System.out.println(a);
		System.out.println(a.element());
	}

}
