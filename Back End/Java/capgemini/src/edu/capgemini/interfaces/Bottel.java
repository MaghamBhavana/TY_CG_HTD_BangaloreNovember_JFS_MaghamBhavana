package edu.capgemini.interfaces;

public interface Bottel {
	void open();
	void drink();
	default void juice()
	{
		System.out.println("Juice");
	}
	static void fruit()
	{
		System.out.println("Static method");
	}
}
