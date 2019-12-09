package com.capgemini.jdbc.controller;

import java.util.Scanner;

import com.capgemini.jdbc.bean.UserBean;
import com.capgemini.jdbc.factory.UserFactory;
import com.capgemini.jdbc.services.UserServices;

public class UserLogin
{
	public static void main(String[] args) 
	{
		UserServices services = UserFactory.instanceOfUserServices();
		UserBean user = new UserBean();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the username");
		user.setUsername(sc.nextLine());
		System.out.println("Enter the password");
		user.setPassword(sc.nextLine());
		
		UserBean u = services.userLogin(user.getUsername(),user.getPassword());
		
		if(u !=null)
		{
			System.out.println("userid "+u.getUserid());
			System.out.println("username "+u.getUsername());
			System.out.println("email "+u.getEmail());
		}
		else
		{
			System.err.println("Something went wrong");
		}
	}

}
