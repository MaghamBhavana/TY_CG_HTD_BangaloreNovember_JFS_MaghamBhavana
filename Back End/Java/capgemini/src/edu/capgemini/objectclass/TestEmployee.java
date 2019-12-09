package edu.capgemini.objectclass;

public class TestEmployee {
	public static void main(String[] args) {
		
		Employee e = new Employee("Bhavana", 22);
		System.out.println(e.hashCode());
		Employee e1=new Employee("Ramya", 21);
		System.out.println(e1.hashCode());
		System.out.println(e1);
		Object o=new Object();
		System.out.println(o.hashCode());
	}

}
