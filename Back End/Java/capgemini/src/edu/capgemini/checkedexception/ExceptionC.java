package edu.capgemini.checkedexception;

public class ExceptionC {
	public static void main(String[] args) {
		
		Employee e=new Employee();
		try 
		{
			Object o=e.clone();
			System.out.println("cloned");
			try
			{
				Class c=Class.forName("edu.capgemini.checkedexception.Employee");
				System.out.println("class found");
			}
			catch(ClassNotFoundException e2)
			{
				System.out.println("class not found");
			}
		} 
		catch (CloneNotSupportedException e1) 
		{
			System.out.println("clone not supported");
		}
	}

}
