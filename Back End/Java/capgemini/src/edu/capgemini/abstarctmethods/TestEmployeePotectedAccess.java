package edu.capgemini.abstarctmethods;

import edu.capgemini.accessspecifiers.Employee;

public class TestEmployeePotectedAccess extends Employee{

	protected TestEmployeePotectedAccess(String EmpName) {
		super(EmpName);
		
	}

	public static void main(String[] args) {
		TestEmployeePotectedAccess a=new TestEmployeePotectedAccess("Bhavana");
		a.m1();//protected can access out side the package that happens only is haves the IS-A relationship

	}

}
