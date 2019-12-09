package edu.capgemini.checkedexception;

public class A {
	
	public static void main(String[] args) {
		
		try {
			B.m();
		} catch (ClassNotFoundException e) {
			System.out.println("exception handled");
		}
	}

}
