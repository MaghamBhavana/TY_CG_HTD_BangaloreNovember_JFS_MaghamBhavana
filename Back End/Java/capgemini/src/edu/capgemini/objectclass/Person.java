package edu.capgemini.objectclass;

public class Person {
	String name;

	public Person(String name) {
		super();
		this.name = name;
	}
	@Override
	protected void finalize() throws Throwable {
		
		super.finalize();
		System.out.println("finalize Method");
	}

}
