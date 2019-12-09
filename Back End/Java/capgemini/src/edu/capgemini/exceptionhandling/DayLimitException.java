package edu.capgemini.exceptionhandling;

public class DayLimitException extends RuntimeException
{
	String msg;

	public DayLimitException() 
	{
		
	}

	public DayLimitException(String msg) 
	{
		this.msg = msg;
	}
	
	@Override
	public String getMessage() 
	{
		return msg;
	}
	
}
