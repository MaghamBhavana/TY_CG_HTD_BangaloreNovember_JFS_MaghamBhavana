package edu.capgemini.exceptionhandling;

public class NestedTryBlock {
	
	void exception(int a,String b)
	{
		try {
			System.out.println(500/a);
			try {
				System.out.println(b.length());
			}
			catch(Exception x)
			{
				System.out.println("dont deal with null");
			}
		}
		catch(Exception e)
		{
			System.out.println("dont deal with zero");
		}
		
	}

}
