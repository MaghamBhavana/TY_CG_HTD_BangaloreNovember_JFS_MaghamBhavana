package edu.capgemini.exceptionhandling;

public class FinallyBlock {
	public static void main(String[] args) {
		System.out.println("main started");
		try
		{
			System.out.println(100/0);
		}
		catch(Exception e)
		{
			System.out.println("Exception is dividing it with 0");
		}
		finally
		{
			System.out.println("All the closing statements are witten here");
		}
		
		System.out.println("main ended");
	}

}
