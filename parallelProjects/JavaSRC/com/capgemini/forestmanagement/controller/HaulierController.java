package com.capgemini.forestmanagement.controller;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;

import com.capgemini.forestmanagement.dto.HaulierBean;
import com.capgemini.forestmanagement.factory.HaulierFactory;
import com.capgemini.forestmanagement.validation.Validations;
import com.capgemini.forestmangement.service.HaulierService;

public class HaulierController {

	static HaulierService service;
	static {
		service = HaulierFactory.instanceOfHaulierServiceImpl();
	}

	public static void haulierLogin() {

		Scanner sc = new Scanner(System.in);
		HaulierBean bean = new HaulierBean();

		while (true) {
			System.out.println("Press 1 to add haulier details");
			System.out.println("Press 2 to search haulier details");
			System.out.println("Press 3 to get list of haulier details");
			System.out.println("Press 4 to update haulier details");
			System.out.println("Press 5 to delete haulier details");
			System.out.println("Press 6 to go homepage");
			System.out.println("Press 7 to logout");

			String ch = sc.next();
			ch = Validations.validCaseForCurdOperations(ch);

			switch (Integer.parseInt(ch)) {
			case 1:
				bean = new HaulierBean();

				System.out.println("Enter the haulier name [e.g:CapGemini, Length should be in between 3 to 25]");
				String haulierName1 = sc.next();
				haulierName1 = Validations.nameValidation(haulierName1);
				bean.setHaulierName(haulierName1);

				System.out.println("Enter the address1 [e.g:#1-17,Whitefield Length should be in between 3 to 25]");
				String haulierAddress1 = sc.next();
				haulierAddress1 = Validations.addressValidation(haulierAddress1);
				bean.setAddress1(haulierAddress1);

				System.out.println("Enter the address2 [e.g:#1-17,Whitefield Length should be in between 3 to 25]");
				String haulierAddress2 = sc.next();
				haulierAddress2 = Validations.addressValidation(haulierAddress2);
				bean.setAddress1(haulierAddress2);

				System.out.println("Enter the town [e.g:Bangalore-1, Length should be in between 3 to 25]");
				String haulierTown = sc.next();
				haulierTown = Validations.townValidation(haulierTown);
				bean.setTown(haulierTown);

				System.out.println("Enter the postal code [Postal code format must be 6 digits number]");
				String haulierPostal = sc.next();
				haulierPostal = Validations.postalCodeValidation(haulierPostal);
				bean.setPostalcode(Integer.parseInt(haulierPostal));

				System.out.println("Enter the email [e.g: Bhavana123@gmail.com]");
				String haulierEmail = sc.next();
				haulierEmail = Validations.emailValidation(haulierEmail);
				bean.setEmail(haulierEmail);

				System.out.println("Enter the phone number [e.g:9967878756 Phone number format must be 10 digits]");
				String haulierTelephone = sc.next();
				haulierTelephone = Validations.phoneNumberValidation(haulierTelephone);
				bean.setTelephone(haulierTelephone);

				HashMap<Integer, HaulierBean> hauliers = service.getAllHauliers();
				int haulierId = hauliers.size() + 1;
				boolean check = service.addHaulier(haulierId, bean);
				if (check) {
					System.out.println("Good, You successfully added haulier details with haulier id" + haulierId);
					System.out.println("--------------------------------------");
				} else {
					System.err.println("Oops, Something went wrong. Please try one more time");
					System.out.println("---------------------------------------");
				}
				break;
			case 2:

				try {
					System.out.println("Enter which haulier id details you want to search");
					int haulierId1 = sc.nextInt();
					Entry<Integer, HaulierBean> haulier = service.getHaulier(haulierId1);
					if (haulier != null) {
						System.out.println("Hi!! Here is your data....");
						System.out.println("*************************************************************");
						System.out.println("Haulier id= " + haulier.getKey());
						System.out.println("Haulier name= " + haulier.getValue().getHaulierName());
						System.out.println("Address1= " + haulier.getValue().getAddress1());
						System.out.println("Address2= " + haulier.getValue().getAddress2());
						System.out.println("Town= " + haulier.getValue().getTown());
						System.out.println("Postal code= " + haulier.getValue().getPostalcode());
						System.out.println("Email= " + haulier.getValue().getEmail());
						System.out.println("Phone number= " + haulier.getValue().getTelephone());

					} else {
						System.err.println("Oops, No data Found");
						System.out.println("---------------------------");
					}
				} catch (Exception e) {
					System.err.println("Input mismatch exception. Please enter valid Input");
				}

				break;
			case 3:
				HashMap<Integer, HaulierBean> haulier1 = service.getAllHauliers();
				if (haulier1 == null) {
					System.err.println("No records Found");
					System.out.println("----------------------------");
				} else {
					for (Entry<Integer, HaulierBean> haulierBean : haulier1.entrySet()) {
						System.out.println("haulier id= "+haulierBean.getKey());
						System.out.println("Haulier name= " + haulierBean.getValue().getHaulierName());
						System.out.println("Address1= " + haulierBean.getValue().getAddress1());
						System.out.println("Address2= " + haulierBean.getValue().getAddress2());
						System.out.println("Town= " + haulierBean.getValue().getTown());
						System.out.println("Postal code= " + haulierBean.getValue().getPostalcode());
						System.out.println("Email= " + haulierBean.getValue().getEmail());
						System.out.println("Phone number= " + haulierBean.getValue().getTelephone());
						System.out.println("******************************************************");
					}
				}
				break;
			case 4:
				bean = new HaulierBean();
				try {
					System.out.println("Enter which haulier id details you want to update");
					int haulierId2 = sc.nextInt();
					Entry<Integer, HaulierBean> haulier = service.getHaulier(haulierId2);
					boolean isFound = false;
					if (haulier != null) {
						isFound = true;
						bean = haulier.getValue();
					}
					if (isFound) {
						boolean update = false;
						do {
							System.out.println("Hi manager, Here is your list to update.....");
							System.out.println("*****************************************");
							System.out.println("Please enter 1 to modify haulier name");
							System.out.println("Please enter 2 to modify street address1");
							System.out.println("Please enter 3 to modify street address2");
							System.out.println("Please enter 4 to modify town");
							System.out.println("Please enter 5 to modify potal code");
							System.out.println("Please enter 6 to modify email");
							System.out.println("Please enter 7 to modify phone number");
							System.out.println("please enter 8 to update all the modified details");
							System.out.println("Please enter 9 to logout");

							String ch1 = sc.next();
							ch1 = Validations.caseUpdateValidation(ch1);
							switch (Integer.parseInt(ch1)) {
							case 1:
								System.out.println(
										"Enter the new haulier name [e.g:CapGemini, Length should be in between 3 to 25]");
								String newName = sc.next();
								newName = Validations.nameValidation(newName);
								bean.setHaulierName(newName);
								break;
							case 2:
								System.out.println(
										"Enter the new address1 [e.g:#1-17,Whitefield Length should be in between 3 to 25]");
								String address2 = sc.next();
								address2 = Validations.addressValidation(address2);
								bean.setAddress1(address2);
								break;
							case 3:
								System.out.println(
										"Enter the new address2 [e.g:#1-17,Whitefield Length should be in between 3 to 25]");
								String address = sc.next();
								address = Validations.addressValidation(address);
								bean.setAddress2(address);
								break;
							case 4:
								System.out.println(
										"Enter the new town [e.g:Bangalore-1, Length should be in between 3 to 25]");
								String town = sc.next();
								town = Validations.townValidation(town);
								bean.setTown(town);
								break;
							case 5:
								System.out.println("Enter the new potal code [Postal code must be 6 digits number]");
								String postal = sc.next();
								postal = Validations.postalCodeValidation(postal);
								bean.setPostalcode(Integer.parseInt(postal));
								break;
							case 6:
								System.out.println("Enter the new email [e.g: Bhavana123@gmail.com]");
								String newEmail = sc.next();
								newEmail = Validations.emailValidation(newEmail);
								bean.setEmail(newEmail);
								break;
							case 7:
								System.out.println(
										"Enter the new phone number [e.g:9967878756 Phone number format must be 10 digits]");
								String phoneNumber = sc.next();
								phoneNumber = Validations.phoneNumberValidation(phoneNumber);
								bean.setTelephone(phoneNumber);
								break;
							case 8:
								update = true;
								break;
							case 9:
								System.exit(0);

							}
						} while (!update);

						boolean haulier2 = service.updateHaulier(haulierId2, bean);
						if (haulier2) {
							System.out.println("Good, You successfully updated haulier details");
							System.out.println("---------------------------");
						} else {
							System.err.println("Oops, Please try again");
							System.out.println("----------------------------------");
						}

					} else {
						System.err.println("No data present with this Id");
					}
				} catch (Exception e) {
					System.err.println("Input mismatch exception. Please, enter valid Input");
				}
				break;
			case 5:

				try {
					System.out.println("Enter which haulier id details you want to delete");
					int haulierId3 = sc.nextInt();
					HashMap<Integer, HaulierBean> haulier2 = service.getAllHauliers();

					boolean isFound2 = false;
					for (Entry<Integer, HaulierBean> haulierBean : haulier2.entrySet()) {

						if (haulierBean.getKey() == haulierId3) {
							isFound2 = true;
						}
					}
					if (isFound2) {
						boolean haulier3 = service.deleteHaulier(haulierId3);
						if (haulier3) {
							System.out.println("Good, you deleted successfully");
							System.out.println("---------------------------");
						} else {
							System.err.println("Oops, Something went wrong. Please try again");
							System.out.println("---------------------------");
						}
					} else {
						System.err.println("No data present with this Id");
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
