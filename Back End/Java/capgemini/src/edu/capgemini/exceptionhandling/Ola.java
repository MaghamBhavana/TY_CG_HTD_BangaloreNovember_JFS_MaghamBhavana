package edu.capgemini.exceptionhandling;

public class Ola {
	
	ThrowKeyGoogleMap g1;

	public Ola(ThrowKeyGoogleMap g1) {
		super();
		this.g1 = g1;
	}
	
	void find(String s)
	{
		try {
				g1.findLocation(s);
		}
		catch(Exception e)
		{
			System.out.println("Ola user plz provide the source location");
		}
	}

}
