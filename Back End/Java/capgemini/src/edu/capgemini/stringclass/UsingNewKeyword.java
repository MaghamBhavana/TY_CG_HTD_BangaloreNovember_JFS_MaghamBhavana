package edu.capgemini.stringclass;

public class UsingNewKeyword {
	public static void main(String[] args) {
		
		String s1=new String("Bhavana");
		System.out.println(s1.hashCode());
		String s2=new String("Ramya");
		System.out.println(s2.hashCode());
		String s3=new String("Balaram");
		System.out.println(s3.hashCode());
		s1=new String("Gowthami");
		System.out.println(s1.hashCode());
		String s4=new String("Bhavana");
		System.out.println(s4.hashCode());
	}

}
