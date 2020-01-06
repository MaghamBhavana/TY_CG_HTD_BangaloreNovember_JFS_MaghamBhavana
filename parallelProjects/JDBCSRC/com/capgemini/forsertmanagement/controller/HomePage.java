package com.capgemini.forsertmanagement.controller;

import java.util.Scanner;

import com.capgemini.forestmanagement.validation.Validations;

public class HomePage {
	public static void managerOptions() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Hello Manager!!!!!");
		System.out.println("******************************************");
		System.out.println("Please, enter 1 for Contract Details!!!!");
		System.out.println("Please, enter 2 for Customer Details!!!!");
		System.out.println("Please, enter 3 for Product Details!!!!");
		System.out.println("Please, enter 4 for Order Details!!!!");
		System.out.println("Please, enter 5 for Haulier Details!!!!");
		System.out.println("Please, enter 6 for Admin Page!!!!");
		System.out.println("Please, enter 7 to Logout!!!");

		String ch = sc.next();
		ch = Validations.validCaseForCurdOperations(ch);
		while (true) {
			switch (Integer.parseInt(ch)) {
			case 1:
				System.out.println("Hi! You are in Contract Page--");
				ContractController.contractorLogic();
				break;
			case 2:
				System.out.println("Hi! You are in Customer Page--");
				CustomerController.customerLogin();
				break;
			case 3:
				System.out.println("Hi! You are in Product Page--");
				ProductController.productLogic();
				break;
			case 4:
				System.out.println("Hi! You are in Order Page--");
				OrderController.orderLogic();
				break;
			case 5:
				System.out.println("Hi! You are in Haulier Page--");
				HaulierController.haulierLogin();
				break;
			case 6:
				System.out.println("Hi! You are in Home Page--");
				AdminPage.main(null);
				break;
			case 7:
				System.exit(0);
			}
		}
	}

}
