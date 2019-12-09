package edu.capgemini.abstarctmethods;

public abstract class Shop {
	
	static int cost=30000;
	int rent;
	Shop(int rent)
	{
		this.rent=rent;
	}
	static
	{
		System.out.println("Static Block");
	}
	{
		System.out.println("non static block");
	}
	void m1()
	{
		System.out.println("concrete method");
		System.out.println("non static data member "+rent);
	}
	abstract void m2();

}
