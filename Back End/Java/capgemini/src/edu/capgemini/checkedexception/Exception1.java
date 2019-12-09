package edu.capgemini.checkedexception;

public class Exception1 {
	public static void main(String[] args)  
	{
		
		System.out.println("main method started");
		
		try 
		{
			Class c=Class.forName("edu.capgemini.checkedexception.Person");
			System.out.println("class found");
		} 
		catch (ClassNotFoundException e)
		{
			System.out.println("class not found");
		}
		System.out.println("main method ended");
		
	}

}