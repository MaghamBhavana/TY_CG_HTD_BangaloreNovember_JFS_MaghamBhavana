package edu.capgemini.exceptionhandling;

public class TestC {
	public static void main(String[] args) {
		System.out.println("main started");
		
		int[] a=new int[2];
		a[0]=1;
		a[1]=2;
		try {
			a[3]=3;
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("The size of array given is 2 and trying to store 3 values");
		}
		
		System.out.println("Main ended");
		
		
	}

}
