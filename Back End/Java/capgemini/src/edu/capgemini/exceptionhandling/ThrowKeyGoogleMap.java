package edu.capgemini.exceptionhandling;

public class ThrowKeyGoogleMap {
	
	void findLocation(String loc)
	{
		try {
			System.out.println(loc.length());
		}
		catch (Exception e) {
			System.out.println("Google user please, provide the location");
			throw e;
		}
	}
	
	

}
