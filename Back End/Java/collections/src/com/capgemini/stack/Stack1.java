package com.capgemini.stack;

import java.util.Stack;

public class Stack1 
{
	public static void main(String[] args) 
	{
		Stack s = new Stack();
		s.add(23);
		s.add(45);
		s.add(88);
		s.push(44);
		s.push(56);
		System.out.println(s);
		s.pop();
		System.out.println(s);
		System.out.println(s.peek());
		System.out.println(s);
		System.out.println(s.search(23));
	}

}
