package edu.capgemini.checkedexception;

public class IRCTC {
	
	void confirmTicket() throws ClassNotFoundException
	{
		try
		{
			Class.forName("edu.capgemini.checkedexception.Paytm");
			System.out.println("ticket is confirmed");
		} 
		catch (ClassNotFoundException e) 
		{
			System.out.println("ticket is not confirmed");
			throw e;
		}
	}

}
