package edu.capgemini.staticandnonstatic;

public class Father {
	
	Father()
	{
		this("Ramya",22);
		System.out.println("A");
	}
	Father(String name,int age)
	{
		
		System.out.println("B");
	}
}
