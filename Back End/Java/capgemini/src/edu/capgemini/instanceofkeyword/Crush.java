package edu.capgemini.instanceofkeyword;

public class Crush {
	void recieve(Phone p)
	{
		if(p instanceof BasicSet)
		{
			System.out.println("Thanks");
		}
		else if(p instanceof Oppo)
		{
			System.out.println("Thank you");
		}
		else if(p instanceof OnePlus)
		{
			System.out.println("Thankyou so much dear");
		}
		else if(p instanceof Apple)
		{
			System.out.println("Love you");
		}
		else
		{
			System.out.println("Idiot");
		}
	}

}
