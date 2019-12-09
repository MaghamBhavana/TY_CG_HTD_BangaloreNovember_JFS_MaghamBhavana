package edu.capgemini.exceptionhandling;

public class SBIAtm {
	public static void main(String[] args) {
		
		System.out.println("Main Started");
		ATMSimulator a=new ATMSimulator();
		try
		{
			a.withDraw(41000);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		System.out.println("Main Ended");
	}

}
