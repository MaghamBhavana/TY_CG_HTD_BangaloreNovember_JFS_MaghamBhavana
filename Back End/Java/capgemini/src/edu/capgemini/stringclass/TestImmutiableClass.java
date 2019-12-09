package edu.capgemini.stringclass;

public class TestImmutiableClass {
	public static void main(String[] args) {
		
		OwnImmutiableClass c= new OwnImmutiableClass("Bhavana", 22);
		System.out.println(c.hashCode());
		c=new OwnImmutiableClass("Ramya", 21);
		System.out.println(c.hashCode());
		
		System.out.println(c.getName());
		System.out.println(c.getAge());
	}
}
