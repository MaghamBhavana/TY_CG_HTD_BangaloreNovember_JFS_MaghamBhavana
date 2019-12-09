package edu.capgemini.methodoverridingandoverloading;

public class Calculator {
	
	int add(int a)
	{
		return a+a;
	}
	int add(int a,int b)
	{
		return a+b;
	}
	double add(double a)
	{
		return a+a;
	}
	
	static void multiply(int a)
	{
		System.out.println("The result of static-int type is "+(a*a));
	}
	static void multiply(int a,int b)
	{
		System.out.println("The result of the static int ,int type is "+(a*b));
	}
	/*void multiply(int a)
	{
		System.out.println("The result of the non static int is ");//error because if is 
		//having same signature
	}*/
}
