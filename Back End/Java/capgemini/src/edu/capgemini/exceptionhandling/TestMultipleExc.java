package edu.capgemini.exceptionhandling;

public class TestMultipleExc {
	public static void main(String[] args) {
		System.out.println("main started");
		MultipleCatch e=new MultipleCatch();
		e.exception(0, "Bhavana");
		e.exception(2, null);
		System.out.println("main ended");
	}

}
