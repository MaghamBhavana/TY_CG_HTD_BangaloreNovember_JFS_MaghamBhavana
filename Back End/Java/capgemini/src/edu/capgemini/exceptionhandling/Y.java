package edu.capgemini.exceptionhandling;

public class Y {

	static void n()
	{
		try
		{
			Z.m();
		}
		catch (Exception e) {
			System.out.println("Y class msg "+e.getMessage());
			throw e;
		}
	}
}
