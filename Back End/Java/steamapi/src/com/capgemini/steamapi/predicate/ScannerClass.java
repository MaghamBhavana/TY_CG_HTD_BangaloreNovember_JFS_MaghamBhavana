package com.capgemini.steamapi.predicate;

import java.util.Scanner;

public class ScannerClass {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the name");
		String name=sc.nextLine();
		System.out.println("Name of the person is "+name);
	}

}
