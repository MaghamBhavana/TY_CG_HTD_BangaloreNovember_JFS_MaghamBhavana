package com.capgemini.module1.contact;

import java.util.Scanner;

public class PhoneMenu {
	public static void main(String[] args) {
		Cases c=new Cases();
		Scanner sc=new Scanner(System.in);
		while(true)
		{
			System.out.println("Enter Your choice");
			System.out.println("1.Show all contacts\n2.Search for Contact\n3.Operate on contact\n4.Exit");
			int ch=sc.nextInt();

			switch (ch)
			{
			case 1:System.out.println("Hi, Here is your Contacts----------");
			c.showAllContacts();
			break;
			case 2:System.out.println("Helloo Bhavana, Now you can search for your contact");
			c.searchForContact();
			break;
			case 3:System.out.println("Now you can Operate Your Contact");
			c.operateContact();
			break;
			case 4:System.exit(0);

			}

		}
	}

}
