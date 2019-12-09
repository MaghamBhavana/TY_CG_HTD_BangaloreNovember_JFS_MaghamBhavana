package edu.capgemini.exceptionhandling;

public class Z {
	static void m()
	{
		try
		{
			System.out.println(10/0);
		}catch (Exception e) {
			System.out.println("Z class msg "+e.getMessage());
			throw e;
		}
	}

}
