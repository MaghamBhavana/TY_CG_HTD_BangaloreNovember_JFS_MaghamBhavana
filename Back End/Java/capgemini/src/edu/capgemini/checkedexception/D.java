package edu.capgemini.checkedexception;

public class D {
	
	static void o() throws ClassNotFoundException
	{
		Class.forName("A");
	}

}
