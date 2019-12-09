package edu.capgemini.staticandnonstatic;

public class TestStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s=new Student();
		System.out.println("Name is "+s.studName);
		System.out.println("Age is "+s.studAge);
		Student s1=new Student("Bhavana",22);
		System.out.println("Name is "+s1.studName);
		System.out.println("Age is "+s1.studAge);
	}

}
