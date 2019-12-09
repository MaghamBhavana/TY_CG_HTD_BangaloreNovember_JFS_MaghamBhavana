package edu.capgemini.typecasting;

public class PrimitiveImplicitAndExplicit {
	
	
	public static void main(String[] args) {
		//implicit casting
		byte b= 4;
		
		short s= b;
		int i=b;
		double d=b;
		long l=b;
		float f=b;
		System.out.println(s);
		System.out.println(i);
		System.out.println(d);
		System.out.println(l);
		System.out.println(f);
		
		//explicit casting
		
		double x=10.11;
		
		int y=(int)x;
		float z=(float)x;
		byte k=(byte)x;
		System.out.println(y);
		System.out.println(z);
		System.out.println(k);
		
		
		
		
	}
}
