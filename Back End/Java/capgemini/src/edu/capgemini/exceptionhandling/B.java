package edu.capgemini.exceptionhandling;

public class B {
	public void write()
	{
		String s=null;
		try {
				System.out.println(s.length());
		}
		catch(NullPointerException e)
		{
			System.out.println("String is empty no point of length");
		}
	}
	
	public static void main(String[] args) {
		System.out.println("main started");
		B b=new B();
		b.write();
		System.out.println("main ended");
	}

}
