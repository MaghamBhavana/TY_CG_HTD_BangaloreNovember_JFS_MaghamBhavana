package edu.capgemini.checkedexception;

public class ExceptionB {
	public static void main(String[] args) {
		
		System.out.println("main start");
		Student s=new  Student();
		try
		{
			Class c = Class.forName("edu.capgemini.checkedexception.Student");
			System.out.println("class found");
			Object o=s.clone();
			System.out.println("cloned");
		} 
		catch (CloneNotSupportedException e) 
		{
			System.out.println("clone not supported");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("class not found");
		}
		System.out.println("main ended");
	}

}
