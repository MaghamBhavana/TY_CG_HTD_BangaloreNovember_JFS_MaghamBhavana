package edu.capgemini.stringclass;

public class StringBufferClass {
	public static void main(String[] args) {
		String s1=new String("Bhavana");
		System.out.println(s1.hashCode());
		s1=s1.concat("Bhavana");
		System.out.println(s1.hashCode());
		StringBuffer s3=new StringBuffer("Bhavana");
		System.out.println(s3.hashCode());
		s3=s3.append("Bhavana");
		System.out.println(s3.hashCode());
	}

}
