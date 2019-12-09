package edu.capgemini.accessspecifiers;

public class TestPrivate {
	public static void main(String[] args) {
		PrivateAccessSpecifier p=new PrivateAccessSpecifier(10);
		//The variable,method cannot access outside the class becos they are private
		//System.out.println("value "+p.x);
		//p.method();
	}
}
