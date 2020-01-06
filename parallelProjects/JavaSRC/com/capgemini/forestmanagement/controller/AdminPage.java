package com.capgemini.forestmanagement.controller;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdminPage {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("*************** Hi, Admin ****************");
		System.out.println("Press 1 for Karnataka Manager");
		System.out.println("Press 2 for Andhra Pradesh Manager");
		System.out.println("Press 3 for Logout");
		String ch = sc.next();
		Pattern pattern = Pattern.compile("^[1-3]{1}$");
		boolean isCorrect = true;
		do {
			Matcher matcher = pattern.matcher(ch);

			if (matcher.matches()) {
				isCorrect = false;
			} else {
				System.err.println("Sorry!!! Your choice is invalid. Please enter valid case");
				ch = sc.next();
			}
		} while (isCorrect);
		while (true) {
			switch (Integer.parseInt(ch)) {
			case 1:
				System.out.println("Hi, Please Login.........");
				System.out.println("********************************");
				System.out.println("Please enter your Username");
				String userName = sc.next();
				Pattern pattern1 = Pattern.compile("^[A-za-z_]{6,20}$");
				boolean isCorrect1 = true;
				do {
					Matcher matcher1 = pattern1.matcher(userName);

					if (matcher1.matches()) {
						isCorrect1 = false;
					} else {
						System.err.println("Your Username is invalid. Please enter valid Username");
						userName = sc.next();
					}
				} while (isCorrect1);
				System.out.println("Please enter your password");
				String password = sc.next();
				Pattern pattern2 = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,15})");
				boolean isCorrect2 = true;
				do {
					Matcher matcher2 = pattern2.matcher(password);

					if (matcher2.matches()) {
						isCorrect2 = false;
					} else {
						System.err.println("Your Password is invalid. Please enter valid Password");
						password = sc.next();
					}
				} while (isCorrect2);
				HomePage.managerOptions();
				break;
			case 2:
				break;
			case 3:
				System.exit(0);
			}

		}

	}

}
