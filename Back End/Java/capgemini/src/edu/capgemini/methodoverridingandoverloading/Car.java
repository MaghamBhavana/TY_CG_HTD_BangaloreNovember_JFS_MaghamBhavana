package edu.capgemini.methodoverridingandoverloading;

public class Car extends Vehicle {
	
	int cost=50000;
	void carDetails()
	{
		int cost=25000;
		System.out.println("Cost of the car in the method "+cost);
		System.out.println("Cost of the car using this in the car class "+this.cost);
		System.out.println("Cost of the car using super in the vehicle class "+super.cost);
	}
}
