package edu.capgemini.objectclass;

public class AnimalGetClassMethod {
	String name;

	public AnimalGetClassMethod(String name) {
		super();
		this.name = name;
	}
	                                                                 
	public AnimalGetClassMethod()
	{
		name="pinky";
	}
	void details()
	{
		System.out.println("Name is "+name);
	}

}
