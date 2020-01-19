package com.capgemini.forsertmanagement.controller;

import java.util.List;
import java.util.Scanner;

import com.capgemini.forestmanagement.dto.UserBean;
import com.capgemini.forestmanagement.factory.UserFactory;
import com.capgemini.forestmanagement.service.UserService;
import com.capgemini.forestmanagement.validation.Validations;


public class HomePage {

	static UserService service;
	static {
		service = UserFactory.instanceOfManagerServiceImpl();
	}

	public static void schedulerOptions() {
		HaulierController.haulierLogin();
	}

	public static void adminOptions() {

		while (true) {
			System.out.println("Welcome Admin");
			System.out.println("**********************************");
			System.out.println("Press 1 for Client Operations");
			System.out.println("Press 2 for Scheduler Operations");
			System.out.println("Press 3 to get all Users");
			System.out.println("Press 4 for Logout");
			System.out.println("Press 5 for Exit");
			Scanner sc = new Scanner(System.in);
			String ch = sc.next();
			ch = Validations.validCaseForAdminOperation(ch);
			String user = "";

			switch (Integer.parseInt(ch)) {
			case 1:
				user = "Client";
				break;
			case 2:
				user = "Scheduler";
				break;
			case 3:
				List<UserBean> usersList = service.getAllUsers();
				if (!usersList.isEmpty()) {
					for (UserBean userBean : usersList) {
						System.out.println("User Id is " + userBean.getId());
						System.out.println("User name is " + userBean.getName());
						System.out.println("User email is " + userBean.getEmail());
						System.out.println("User Role " + userBean.getRole());
						System.out.println("User Phone number "+userBean.getPhoneNumber());
						System.out.println("*************************************");
					}
				}
				break;
			case 4:
				LoginPage.main(null);
				break;
			case 5:
				System.exit(0);
			default:
				break;
			}
			if (Integer.parseInt(ch) == 1 || Integer.parseInt(ch) == 2) {

				System.out.println("press 1 to add " + user);
				System.out.println("Press 2 to delete " + user);
				int ch1 = sc.nextInt();
				switch (ch1) {
				case 1:
					UserBean userDetails = new UserBean();
					System.out.println("Enter name of " + user);
					String name = sc.next();
					name = Validations.nameValidation(name);
					userDetails.setName(name);
					System.out.println("Enter email of " + user);
					String email = sc.next();
					email = Validations.emailValidation(email);
					userDetails.setEmail(email);
					System.out.println("Enter password of " + user);
					String password = sc.next();
					password = Validations.passwordValidation(password);
					userDetails.setPassword(password);
					System.out.println("Enter phonenumber of " + user);
					String phoneNumber = sc.next();
					phoneNumber = Validations.phoneNumberValidation(phoneNumber);
					userDetails.setPhoneNumber(Long.parseLong(phoneNumber));
					userDetails.setRole(user);
					System.out.println("Enter Id of "+user);
					String id = sc.next();
					id = Validations.IdValidation(id);
					userDetails.setId(Integer.parseInt(id));
					boolean id1 = service.addUser(userDetails);
					if(id1) {
					System.out.println("New " + user + " has been saved succesfully with id " + id);
					} else {
						System.err.println("Unable to add "+user+" please try again!!");
					}
					break;
				case 2:
					System.out.println("Enter the " + user + " email you want to delete");
					String email1 = sc.next();
					boolean isDeleted = service.deleteUser(email1);
					if (isDeleted) {
						System.out.println(user + " with email " + email1 + " has been deleted successfully");
					} else {
						System.err.println("Unable to delete " + user + " with Id " + email1);
					}
					break;
				default:
					break;
				}
			}
		}

	}

	public static void clientOptions() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Hello Client!!!!!");
		System.out.println("******************************************");
		System.out.println("Please, enter 1 for Contract Details!!!!");
		System.out.println("Please, enter 2 for Customer Details!!!!");
		System.out.println("Please, enter 3 for Product Details!!!!");
		System.out.println("Please, enter 4 for Order Details!!!!");
		System.out.println("Please, enter 5 for Logout!!!!");
		System.out.println("Please, enter 6 to Exit!!!");

		String ch = sc.next();
		ch = Validations.validCaseForCrudOperations(ch);
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
				LoginPage.main(null);
				break;
			case 6:
				System.exit(0);
			}// end of switch
		} // end of while
	}// end of managerOptions method

}// end of class
