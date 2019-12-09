package com.capgemini.set.linkedhashset;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class CustomEmployee 
{
	public static void main(String[] args) {
		
		LinkedHashSet<Employee> e = new LinkedHashSet<Employee>();
		
		e.add(new Employee(123, "Bhavana"));
		e.add(new Employee(124, "Ramya"));
		e.add(new Employee(123, "Bhavana"));
		e.add(new Employee(126, "Balaram"));
		
		/*for (Employee em : e) {
			System.out.println(em.empId+" is having a name of "+em.empName);
		}*/
		
		Iterator<Employee> m = e.iterator();
		while(m.hasNext())
		{
			System.out.println(m.next());
		}
		
	}

}
