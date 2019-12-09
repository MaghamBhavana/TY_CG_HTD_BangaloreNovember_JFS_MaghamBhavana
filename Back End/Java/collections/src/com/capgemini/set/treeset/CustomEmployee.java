package com.capgemini.set.treeset;

import java.util.TreeSet;

public class CustomEmployee {
	public static void main(String[] args) {
		EmployeeName e1 = new EmployeeName();
		EmployeeAge e2 = new EmployeeAge();
		EmployeeSalary e3 = new EmployeeSalary();
		TreeSet<Employee> e = new TreeSet<Employee>(e3);
		
		e.add(new Employee(23, "Bhavana", 25000));
		e.add(new Employee(22, "Ramya", 100000));
		e.add(new Employee(39, "Chandrika", 20000));
		e.add(new Employee(55, "Koteswararao", 200000));
		
		for (Employee em : e) {
			System.out.println(em);
		}
	}

}
