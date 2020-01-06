package com.capgemini.forestmanagement.controller;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;

import com.capgemini.forestmanagement.dto.CustomerBean;
import com.capgemini.forestmanagement.factory.CustomerFactory;
import com.capgemini.forestmanagement.validation.Validations;
import com.capgemini.forestmangement.service.CustomerService;

public class CustomerController {
	static CustomerService service;
	static {
		service = CustomerFactory.instanceOfCustomerServiceImpl();
	}

	public static void customerLogin() {

		Scanner sc = new Scanner(System.in);
		CustomerBean bean = new CustomerBean();

		while (true) {
			System.out.println("Press 1 to add customer details");
			System.out.println("Press 2 to search customer details");
			System.out.println("Press 3 to get list of customer details");
			System.out.println("Press 4 to update customer details");
			System.out.println("Press 5 to delete customer details");
			System.out.println("Press 6 to go homepage");
			System.out.println("Press 7 to logout");
			String ch = sc.next();
			ch = Validations.validCaseForCurdOperations(ch);
			switch (Integer.parseInt(ch)) {
			case 1:
				bean = new CustomerBean();

				System.out.println("Enter the customer name [e.g:CapGemini, Length should be in between 3 to 25]");
				String customerName = sc.next();
				customerName = Validations.nameValidation(customerName);
				bean.setCustomerName(customerName);

				System.out.println(
						"Enter the street address1 [e.g:#1-17,Whitefield Length should be in between 3 to 25]");
				String address1 = sc.next();
				address1 = Validations.addressValidation(address1);
				bean.setStreetAddress1(address1);

				System.out.println(
						"Enter the street address2 [e.g:#1-17,Whitefield Length should be in between 3 to 25]");
				String address2 = sc.next();
				address2 = Validations.addressValidation(address2);
				bean.setStreetAddress2(address2);

				System.out.println("Enter the town [e.g:Bangalore-1, Length should be in between 3 to 25]");
				String town = sc.next();
				town = Validations.townValidation(town);
				bean.setTown(town);

				System.out.println("Enter the postal code [Postal code format must be 6 digits number]");
				String postalCode = sc.next();
				postalCode = Validations.postalCodeValidation(postalCode);
				bean.setPostalCode(Integer.parseInt(postalCode));

				System.out.println("Enter the email [e.g: Bhavana123@gmail.com]");
				String email = sc.next();
				email = Validations.emailValidation(email);
				bean.setEmail(email);

				System.out.println("Enter the phone number [e.g:9967878756 Phone number format must be 10 digits]");
				String phoneNumber = sc.next();
				phoneNumber = Validations.phoneNumberValidation(phoneNumber);
				bean.setPhoneNo(phoneNumber);

				HashMap<Integer, CustomerBean> customers = service.getAllCustomers();
				int customerId = customers.size() + 1;
				boolean check = service.addCustomer(customerId, bean);

				if (check) {
					System.out.println("Good, You successfully added the details with customer id " + customerId);
					System.out.println("--------------------------------------");
				} else {
					System.err.println("Oops, Something went wrong. Please add one more time");
					System.out.println("---------------------------------------");
				}
				break;

			case 2:

				try {
					System.out.println("Enter which customer id details you want to search");
					int customerId1 = sc.nextInt();
					Entry<Integer, CustomerBean> customer = service.getCustomer(customerId1);
					if (customer != null) {
						System.out.println("Hi!! Here is your data....");
						System.out.println("*************************************************************");
						System.out.println("Customer id= " + customer.getKey());
						System.out.println("Customer name= " + customer.getValue().getCustomerName());
						System.out.println("Street address1= " + customer.getValue().getStreetAddress1());
						System.out.println("Street address2= " + customer.getValue().getStreetAddress2());
						System.out.println("Town= " + customer.getValue().getTown());
						System.out.println("Postal code= " + customer.getValue().getPostalCode());
						System.out.println("Email= " + customer.getValue().getEmail());
						System.out.println("Phone number= " + customer.getValue().getPhoneNo());
						System.out.println("--------------------------------------");

					} else {
						System.err.println("Oops!!! No data found....");
						System.out.println("---------------------------");
					}
				} catch (Exception e) {
					System.err.println("Input mismatch exception. Please enter valid input");
				}

				break;

			case 3:
				HashMap<Integer, CustomerBean> customer1 = service.getAllCustomers();
				if (customer1 == null) {
					System.err.println("Sorry!!!  No records found....");
					System.out.println("----------------------------");
				} else {
					for (Entry<Integer, CustomerBean> customerBean : customer1.entrySet()) {
						System.out.println("Customer id= " + customerBean.getKey());
						System.out.println("Customer name= " + customerBean.getValue().getCustomerName());
						System.out.println("Street address1= " + customerBean.getValue().getStreetAddress1());
						System.out.println("Street address2= " + customerBean.getValue().getStreetAddress2());
						System.out.println("Town= " + customerBean.getValue().getTown());
						System.out.println("Postal code= " + customerBean.getValue().getPostalCode());
						System.out.println("Email= " + customerBean.getValue().getEmail());
						System.out.println("Phone number= " + customerBean.getValue().getPhoneNo());
						System.out.println("************************************************************");
					}
				}
				break;
			case 4:
				bean = new CustomerBean();
				try {
					System.out.println("Enter which customer id details you want to update");
					int customerId2 = sc.nextInt();

					Entry<Integer, CustomerBean> customer = service.getCustomer(customerId2);
					boolean isFound = false;
					if (customer != null) {
						isFound = true;
						bean = customer.getValue();
					}

					if (isFound) {
						boolean update = false;
						do {
							System.out.println("Hi manager, Here is your list to update.....");
							System.out.println("*****************************************");
							System.out.println("Please enter 1 to modify customer name");
							System.out.println("Please enter 2 to modify street address1");
							System.out.println("Please enter 3 to modify street address2");
							System.out.println("Please enter 4 to modify town");
							System.out.println("Please enter 5 to modify postal code");
							System.out.println("Please enter 6 to modify email");
							System.out.println("Please enter 7 to modify phone number");
							System.out.println("Please enter 8 to update all the modified details");
							System.out.println("Please enter 9 to logout");
							String ch1 = sc.next();
							ch1 = Validations.caseUpdateValidation(ch1);
							switch (Integer.parseInt(ch1)) {
							case 1:
								System.out.println(
										"Enter the new customer name [e.g:CapGemini, Length should be in between 3 to 25]");
								String newName = sc.next();
								newName = Validations.nameValidation(newName);
								bean.setCustomerName(newName);
								break;
							case 2:
								System.out.println(
										"Enter the new street address1 [e.g:#1-17,Whitefield Length should be in between 3 to 25]");
								String address3 = sc.next();
								address3 = Validations.addressValidation(address3);
								bean.setStreetAddress1(address3);
								break;
							case 3:
								System.out.println(
										"Enter the new street address2 [e.g:#1-17,Whitefield Length should be in between 3 to 25]");
								String address4 = sc.next();
								address4 = Validations.addressValidation(address4);
								bean.setStreetAddress2(address4);
								break;
							case 4:
								System.out.println(
										"Enter the new town [e.g:Bangalore-1, Length should be in between 3 to 25]");
								String town1 = sc.next();
								town1 = Validations.townValidation(town1);
								bean.setStreetAddress2(town1);
								break;
							case 5:
								System.out.println("Enter the new postal code [Postal code must be 6 digits number]");
								String postalCode1 = sc.next();
								postalCode1 = Validations.postalCodeValidation(postalCode1);
								bean.setPostalCode(Integer.parseInt(postalCode1));
								break;
							case 6:
								System.out.println("Enter the new email [e.g: Bhavana123@gmail.com]");
								String email1 = sc.next();
								email1 = Validations.emailValidation(email1);
								bean.setEmail(email1);
								break;
							case 7:
								System.out.println(
										"Enter the new phone number [e.g:9967878756 Phone number format must be 10 digits]");
								String phoneNumber1 = sc.next();
								phoneNumber1 = Validations.phoneNumberValidation(phoneNumber1);
								bean.setPhoneNo(phoneNumber1);
								break;
							case 8:
								update = true;
								break;
							case 9:
								System.exit(0);

							}
						} while (!update);

						boolean customer2 = service.updateCustomer(customerId2, bean);

						if (customer2) {
							System.out.println("Good, You updated Successfully---");
							System.out.println("---------------------------");
						} else {
							System.err.println("Oops, Something went wrong. Please try again...");
							System.out.println("----------------------------------");
						}
					} else {
						System.err.println("No data found with this Id");
					}
				} catch (Exception e) {
					System.err.println("Input mismatch exception. Please enter valid input");

				}

				break;
			case 5:

				try {
					System.out.println("Enter which customer id details you want delete");
					int customerId3 = sc.nextInt();
					HashMap<Integer, CustomerBean> customer2 = service.getAllCustomers();

					boolean isCustomerfound1 = false;
					for (Entry<Integer, CustomerBean> customerBean : customer2.entrySet()) {

						if (customerBean.getKey() == customerId3) {
							isCustomerfound1 = true;
						}
					}
					if (isCustomerfound1) {
						boolean customer3;
						customer3 = service.deleteCustomer(customerId3);
						if (customer3) {
							System.out.println("Good, you Deleted successfully");
							System.out.println("---------------------------");
						} else {
							System.err.println("Oops, Something went wrong. Please try again...");
							System.out.println("---------------------------");
						}
					} else {
						System.err.println("No data is present with this Id");
					}
				} catch (Exception e) {
					System.err.println("Input mismatch exception. Please enter valid Input");
				}

				break;
			case 6:
				HomePage.managerOptions();
				break;
			case 7:
				System.exit(0);

			}
		}
	}
}
