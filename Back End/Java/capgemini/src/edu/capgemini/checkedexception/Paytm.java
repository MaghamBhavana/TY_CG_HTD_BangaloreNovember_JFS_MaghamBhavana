package edu.capgemini.checkedexception;

public class Paytm {
	
	IRCTC i1;

	public Paytm(IRCTC i1) 
	{
		this.i1 = i1;
	}
	void bookTicket()
	{
		try 
		{
			i1.confirmTicket();
			System.out.println("ticket is comfirmed");
		} 
		catch (ClassNotFoundException e)
		{
			System.out.println("Ticket not confirmed");
		}
	}
	

}
