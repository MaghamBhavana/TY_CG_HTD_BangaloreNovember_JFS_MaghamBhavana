package com.capgemini.queue.priorityqueue;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueue1 {
	public static void main(String[] args) {
		
		Queue q = new PriorityQueue();
		
		q.offer(12);
		q.offer(34);
		q.offer(45);
		q.offer(89);
		q.offer(34);
		//q.offer(null);
		System.out.println(q);
		q.poll();
		q.poll();
		q.remove();
		System.out.println(q);
		System.out.println(q.peek());
		System.out.println(q.element());
		
		
 	}
 	

}
