package edu.capgemini.objectclass;

public class Employee {
	
	String name;
	int id;
	public Employee(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + "]";
	}
	

}
