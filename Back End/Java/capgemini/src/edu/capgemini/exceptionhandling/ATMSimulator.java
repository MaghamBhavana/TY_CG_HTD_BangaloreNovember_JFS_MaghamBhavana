package edu.capgemini.exceptionhandling;

public class ATMSimulator {
	
	void withDraw(int amount)
	{
		if(amount > 40000)
		{
			throw new DayLimitException("Exceeds the Day Limit");
		}
	}

}
