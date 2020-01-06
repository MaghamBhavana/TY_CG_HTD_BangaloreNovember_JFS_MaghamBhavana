package com.capgemini.forsertmanagement.controller;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.forestmanagement.dto.ManagerBean;
import com.capgemini.forestmanagement.service.ManagerService;
import com.capgemini.forestmanagement.service.ManagerServiceImpl;

public class AdminPage {
	public static void main(String[] args) {
		ManagerService service = new ManagerServiceImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("Hi, Admin *******************");
		System.out.println("Press 1 for Karnataka Manager");
		System.out.println("Press 2 for Register");
		System.out.println("Press 3 for Logout");
		String ch = sc.next();
		Pattern pattern = Pattern.compile("^[1-3]{1}$");
		boolean isCorrect = true;
		do {
			Matcher matcher = pattern.matcher(ch);

			if (matcher.matches()) {
				isCorrect = false;
			} else {
				System.err.println("Sorry!!!, Please enter valid case");
				ch = sc.next();
			}
		} while (isCorrect);
		while (true) {
			switch (Integer.parseInt(ch)) {
			case 1:
				System.out.println("Hi, Please Login.........");
				System.out.println("********************************");
				System.out.println("Please enter your user name(Abc_Abc 6-20 Characters)");
				String userName = sc.next();
				Pattern pattern1 = Pattern.compile("^[A-za-z_]{6,20}$");
				boolean isCorrect1 = true;
				do {
					Matcher matcher1 = pattern1.matcher(userName);

					if (matcher1.matches()) {
						isCorrect1 = false;
					} else {
						System.err.println("Sorry!!!, Please enter valid User Name");
						userName = sc.next();
					}
				} while (isCorrect1);
				System.out.println("Please enter your password(Aba123@ 8-15 Characters)");
				String password = sc.next();
				Pattern pattern2 = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,15})");
				boolean isCorrect2 = true;
				do {
					Matcher matcher2 = pattern2.matcher(password);

					if (matcher2.matches()) {
						isCorrect2 = false;
					} else {
						System.err.println("Sorry!!!, Please enter valid Password");
						password = sc.next();
					}
				} while (isCorrect2);
				ManagerBean bean = service.login(userName, password);
				if(bean != null) {
				if (userName.equals(bean.getUsername()) && password.equals(bean.getPassword())) {
					HomePage.managerOptions();
				} else {
					System.err.println("Invalid Credentials");
				}
				} else {
					System.err.println("Invalid user name are password");
				}
				break;
			case 2:
				System.out.println("Hi, Please Register.........");
				System.out.println("********************************");
				System.out.println("Please enter your user name(Abc_Abc 6-20 Characters)");
				String userName1 = sc.next();
				Pattern pattern3 = Pattern.compile("^[A-za-z_]{6,20}$");
				boolean isCorrect3 = true;
				do {
					Matcher matcher3 = pattern3.matcher(userName1);

					if (matcher3.matches()) {
						isCorrect3 = false;
					} else {
						System.err.println("Sorry!!!, Please enter valid User Name");
						userName1 = sc.next();
					}
				} while (isCorrect3);
				System.out.println("Please enter your password(Aba123@ 8-15 Characters)");
				String password1 = sc.next();
				Pattern pattern4 = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,15})");
				boolean isCorrect4 = true;
				do {
					Matcher matcher4 = pattern4.matcher(password1);

					if (matcher4.matches()) {
						isCorrect4 = false;
					} else {
						System.err.println("Sorry!!!, Please enter valid Password");
						password1 = sc.next();
					}
				} while (isCorrect4);

				boolean check = service.add(userName1, password1);
				if (check) {
					System.out.println("Registed successfully---");
					AdminPage.main(null);
				} else {
					System.err.println("Please register again");
				}
				break;
			case 3:
				System.exit(0);
			}

		}

	}

}
