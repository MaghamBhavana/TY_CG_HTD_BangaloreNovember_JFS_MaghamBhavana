package com.capgemini.jdbc.controller;

import java.util.Scanner;

import com.capgemini.jdbc.bean.UserBean;
import com.capgemini.jdbc.factory.UserFactory;
import com.capgemini.jdbc.services.UserServices;

public class UpdateUser {
	public static void main(String[] args) {
		UserServices services = UserFactory.instanceOfUserServices();
		UserBean user = new UserBean();
		Scanner sc =new Scanner(System.in);
		
		System.out.println("Enter the UserId----");
		user.setUserid(Integer.parseInt(sc.nextLine()));
		//int id=sc.nextInt();
		System.out.println("Enter the password---");
		user.setPassword(sc.nextLine());
		System.out.println("Enter New Email");
		user.setEmail(sc.nextLine());
		
		if(services.updateUser(user.getUserid(),user.getPassword(),user.getEmail()))
		{
			System.out.println("User Updated---");
		}
		else
		{
			System.err.println("Something went wrong");
		}
		sc.close();
	}

}
