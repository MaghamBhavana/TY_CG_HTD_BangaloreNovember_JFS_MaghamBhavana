package edu.capgemini.boxingandunboxing;

public class TestA {
	public static void main(String[] args) {
		
		int i=10;
		
		//Boxing
		Integer i1=new Integer(i);
		System.out.println("Non primitive type "+i1);
		
		//Unboxing
		int i2=i1.intValue();
		System.out.println("Primitive type "+i2);
		
		double d=21.89;
		
		//Boxing
		Double d1=new Double(d);
		System.out.println("Non primitive type "+d1);
		
		//Unboxing
		double d2=d1.doubleValue();
		System.out.println("Primitive type "+d2);
	}

}
