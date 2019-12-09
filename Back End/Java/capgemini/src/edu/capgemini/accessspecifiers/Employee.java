package edu.capgemini.accessspecifiers;

public class Employee {
	protected String EmpName;
	
	protected Employee(String EmpName)
	{
		this.EmpName=EmpName;
	}
	
	protected void m1()
	{
		System.out.println("Name of the employee "+EmpName);
	}

}
