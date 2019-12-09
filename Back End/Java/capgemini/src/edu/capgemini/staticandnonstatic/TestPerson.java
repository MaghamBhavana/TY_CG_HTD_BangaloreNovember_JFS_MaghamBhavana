package edu.capgemini.staticandnonstatic;

public class TestPerson
{
	public static void main(String[] args) {
		Person p1=new Person();
		p1.age=23;
		p1.name="Bhavana";
		p1.personDetails();
		Person p2=new Person();
		p2.initialize(22,"Ramya");
		p2.personDetails();
	}

}
