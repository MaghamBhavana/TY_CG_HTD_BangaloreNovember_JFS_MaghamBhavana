package edu.capgemini.methodoverridingandoverloading;

public class TestCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator c=new Calculator();
		int r1=c.add(2);
		System.out.println("Result of int type method is "+r1);
		
		int r2=c.add(2,7);
		System.out.println("Result of int,int type method is "+r2);
		
		double r3=c.add(12.89);
		System.out.println("Result of double type method is "+r3);
		
		Calculator.multiply(10);
		Calculator.multiply(12, 2);
	
	}

}
