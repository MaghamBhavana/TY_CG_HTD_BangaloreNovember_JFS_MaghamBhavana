package edu.capgemini.accessspecifiers;

public class PublicAccess {
	
	public String name;
	public static int age=10;
	
	public PublicAccess(String name)
	{
		this.name=name;
	}
	public void m1()
	{
		System.out.println("name is "+name);
	}
	public static void m2()
	{
		System.out.println("satic method");
	}

}
