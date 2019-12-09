package edu.capgemini.exceptionhandling;

public class TestA {
	
	public static void main(String[] args) {
		System.out.println("main method started");
		A a=new A();
		a.divide(10, 0);
		System.out.println("main ended");
	}

}
