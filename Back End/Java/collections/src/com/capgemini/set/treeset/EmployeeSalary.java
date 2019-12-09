package com.capgemini.set.treeset;

import java.util.Comparator;

public class EmployeeSalary implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		if(o1.salary > o2.salary)
			return 1;
		else if(o1.salary < o2.salary)
			return -1;
		else
			return 0;
	}

}
