package edu.capgemini.checkedexception;

public class AgeLimitException extends Exception
{
	
	String msg="Age should be greater than 18";

	public AgeLimitException() 
	{
		
	}

	public AgeLimitException(String msg) 
	{
		this.msg = msg;
	}
	
	public String getMessage()
	{
		return msg;
	}

}
