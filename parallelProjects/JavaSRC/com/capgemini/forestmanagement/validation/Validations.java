package com.capgemini.forestmanagement.validation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validations {

	static Validations vObj;
	static {
		vObj = new Validations();
	}

	public static String nameValidation(String name) {
		Pattern pattern = Pattern.compile("^[a-zA-Z]{3,25}$");
		return vObj.checkValidation("name", name, pattern);

	}

	public static String IdValidation(String id) {
		Pattern pattern = Pattern.compile("[1-9]{1}[0-9]{0,3}$");
		return vObj.checkValidation("id", id, pattern);
	}

	public static String dateValidation(String date) {
		Pattern pattern = Pattern.compile("([12]\\d{3}(\\/)(0[1-9]|1[0-2])(\\/)(0[1-9]|[12]\\d|3[01]))");
		return vObj.checkValidation("date", date, pattern);
	}

	public static String validCaseForCurdOperations(String case1) {
		Pattern pattern = Pattern.compile("^[1-7]{1}$");
		return vObj.checkValidation("case", case1, pattern);
	}

	public static String validCaseForUpdateOperation(String case1) {
		Pattern pattern = Pattern.compile("^[1-8]{1}$");
		return vObj.checkValidation("case", case1, pattern);
	}

	public static String addressValidation(String address) {
		Pattern pattern = Pattern.compile("^[a-zA-Z0-9-_#,]{3,25}$");
		return vObj.checkValidation("address", address, pattern);
	}

	public static String townValidation(String town) {
		Pattern pattern = Pattern.compile("^[a-zA-Z0-9]{3,25}$");
		return vObj.checkValidation("town", town, pattern);
	}

	public static String quantityValidation(String quantity) {
		Pattern pattern = Pattern.compile("[1-9]{1}[0-9]{0,3}$");
		return vObj.checkValidation("quantity", quantity, pattern);
	}

	public static String postalCodeValidation(String postalCode) {
		Pattern pattern = Pattern.compile("^[1-9]{1}[0-9]{2}\\s{0,1}[0-9]{3}$");
		return vObj.checkValidation("postalCode", postalCode, pattern);
	}

	public static String emailValidation(String email) {
		Pattern pattern = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$");
		return vObj.checkValidation("email", email, pattern);
	}

	public static String phoneNumberValidation(String phoneNumber) {
		Pattern pattern = Pattern.compile("^[6-9][0-9]{9}$");
		return vObj.checkValidation("phoneNumber", phoneNumber, pattern);
	}

	public static String caseUpdateValidation(String case1) {
		Pattern pattern = Pattern.compile("^[1-9]{1}$");
		return vObj.checkValidation("case", case1, pattern);
	}

	public String checkValidation(String type, String value, Pattern pattern) {
		Scanner sc = new Scanner(System.in);
		boolean isCorrect2 = true;
		do {
			Matcher matcher2 = pattern.matcher(value);

			if (matcher2.matches()) {
				isCorrect2 = false;
			} else {
				System.err.println("Sorry!!! Please enter valid " + type);
				value = sc.next();
			}
		} while (isCorrect2);
		return value;
	}

}
