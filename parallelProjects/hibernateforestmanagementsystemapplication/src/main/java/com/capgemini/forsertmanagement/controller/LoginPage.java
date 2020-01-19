package com.capgemini.forsertmanagement.controller;

import java.util.Scanner;

import com.capgemini.forestmanagement.dto.UserBean;
import com.capgemini.forestmanagement.factory.UserFactory;
import com.capgemini.forestmanagement.service.UserService;
import com.capgemini.forestmanagement.validation.Validations;


public class LoginPage {
	public static void main(String[] args) {
		UserService service = UserFactory.instanceOfManagerServiceImpl();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("**************************************************************");
			System.out.println("--------WELCOME TO FOREST MANAGEMENT SYSTEM APPLICATION-------");
			System.out.println("***************************************************************");
			System.out.println("Press 1 for Login");
			System.out.println("Press 2 for Exit");

			String ch = sc.next();
			ch = Validations.adminCasesValidations(ch);

			switch (Integer.parseInt(ch)) {
			case 1:// login
				try {
					System.out.println("Hi, Please Login.........");
					System.out.println("********************************");
					System.out.println("Please enter your email");
					String email = sc.next();
					System.out.println("Please enter your password");
					String password = sc.next();
					System.out.println("Please enter your role");
					String role = sc.next();
					UserBean bean = service.login(email, password, role);
					role = Validations.roleValidation(role);
					if (bean != null) {
						if (role.equalsIgnoreCase("Admin")) {
							HomePage.adminOptions();

						} else if (role.equalsIgnoreCase("Client")) {
							HomePage.clientOptions();
						} else {
							HomePage.schedulerOptions();
						}
					}  else {
						System.err.println("Invalid Credentials");
					}
				} 
				catch (Exception e) {
					System.err.println("Input mismatch please enter valid input");
				}
				break;

			case 2:
				System.exit(0);
			default:
				break;
			}// end of switch case

		} // end of while loop

	}// end of main method

}// end of class
