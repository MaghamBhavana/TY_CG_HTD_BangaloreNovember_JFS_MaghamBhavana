package edu.capgemini.staticandnonstatic;

public class Employee 
{
	String empName;
	int empId;
	double empSalary;
	
	Employee(String name,int id,double salary)
	{
		empName=name;
		empId=id;
		empSalary=salary;
	}
	void details()
	{
		System.out.println("Name: "+empName+" Id: "+empId+" salary "+empSalary);
	}

}
