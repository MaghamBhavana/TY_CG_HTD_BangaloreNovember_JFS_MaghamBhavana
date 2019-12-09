package edu.capgemini.exceptionhandling;

public class X {
	
	static void o()
	{
		try
		{
			Y.n();
		}
		catch(Exception e)
		{
			System.out.println("X class msg "+e.getMessage());
		}
	}

}
