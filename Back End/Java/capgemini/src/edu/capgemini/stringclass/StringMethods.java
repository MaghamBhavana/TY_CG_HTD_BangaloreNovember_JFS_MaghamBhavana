package edu.capgemini.stringclass;

public class StringMethods {
	
	public static void main(String[] args) {
		
		String s="Bhavana, How are you???";
		String s1="Ramya";
		String s2="Ramya";
		
		System.out.println(s.toLowerCase());
		System.out.println(s.toUpperCase());
		System.out.println(s.charAt(0));
		System.out.println(s.compareTo(s1));
		System.out.println(s1.compareToIgnoreCase(s2));
		System.out.println(s.concat(s1));
		System.out.println(s1.contains(s2));
		//System.out.println(s1.contentEquals(s2));
		System.out.println(s.endsWith("??"));
		System.out.println(s1.equals(s2));
		System.out.println(s.equalsIgnoreCase(s2));
		System.out.println(s.indexOf('h'));
	}

}
