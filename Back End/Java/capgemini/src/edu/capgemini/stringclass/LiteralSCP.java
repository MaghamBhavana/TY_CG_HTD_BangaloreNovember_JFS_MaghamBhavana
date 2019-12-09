package edu.capgemini.stringclass;

public class LiteralSCP {
	
	public static void main(String[] args) {
		
		String s1="bhavana";
		System.out.println("Hash code of the s1 first "+s1.hashCode());
		String s2="Ramya";
		System.out.println("Hash code of the s2 first "+s2.hashCode());
		s1="Balaram";
		System.out.println("Hash code of the s1 second "+s1.hashCode());
		String s3="bhavana";
		System.out.println("Hash code of the s3 first with s1 first content "+s3.hashCode());
		
	}

}
