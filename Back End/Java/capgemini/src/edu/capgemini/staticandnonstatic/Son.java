package edu.capgemini.staticandnonstatic;

public class Son extends Father {
	
	Son()
	{
		super();
		System.out.println("C");
	}
	Son(String name,int age)
	{
		this();
		System.out.println("D");
	}
}
