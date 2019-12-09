package edu.capgemini.methodoverridingandoverloading;

public class Cat extends Animal{
	
	@Override
	void eat()
	{
		System.out.println("Cat is eating");
	}

}
