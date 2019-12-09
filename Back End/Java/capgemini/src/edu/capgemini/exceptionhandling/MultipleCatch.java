package edu.capgemini.exceptionhandling;

public class MultipleCatch {
	
	void exception(int a,String b)
	{
		try 
		{
			System.out.println(250/a);
			System.out.println(b.length());
		}
		catch(ArithmeticException e)
		{
			System.out.println("Don't deal with the Zero");
		}
		catch(NullPointerException x)
		{
			System.out.println("Don't deal with the null");
		}
		try
		{
			System.out.println(b.length());
		}
		catch(ArithmeticException e)
		{
			System.out.println("Don't deal with the Zero");
		}
		catch(NullPointerException x)
		{
			System.out.println("Don't deal with the null");
		}
		
	}

}
