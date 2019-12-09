package edu.capgemini.exceptionhandling;

public class A {
	
	public void divide(int a,int b)
	{
		System.out.println("divide method started");
		try 
		{
			System.out.println(a/b);
		} 
		catch (Exception e) 
		{
			System.out.println("Exception msg: It is dividing with zero");
		}
		
		System.out.println("divide method ended");
	}
}
