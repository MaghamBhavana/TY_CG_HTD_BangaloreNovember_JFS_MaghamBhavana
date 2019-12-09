package edu.capgemini.objectclass;

public class TestEmployee1 {
	public static void main(String[] args) {
		
		Employee1 e=new Employee1("Bhavana", 1);
		Employee1 e1=new Employee1("Bhavana", 1);
		Employee1 e2=new Employee1("Ramya", 2);
		System.out.println(e.equals(e1));
		System.out.println(e.hashCode());
		System.out.println(e1.hashCode());
		System.out.println(e2.hashCode());
	}
}
