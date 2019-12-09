package com.capgemini.queue.priorityqueue;

import java.util.PriorityQueue;

public class CustomStudent {
	public static void main(String[] args) {
		
		PriorityQueue<Student> p = new PriorityQueue<Student>();
		p.offer(new Student(22, "Bhavana"));
		p.offer(new Student(23, "Ramya"));
		p.offer(new Student(22, "Bhavana"));
		
		for (Student s : p) {
			System.out.println(s);
		}
	}

}
