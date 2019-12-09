package edu.capgemini.objectclass;

public class EqualsMethod {
	public static void main(String[] args) {
		
		String s1="Bhavana";
		String s2= new String("Bhavana");
		
		System.out.println(s1.equals(s2));
		System.out.println(s1 == s2);
	}

}
