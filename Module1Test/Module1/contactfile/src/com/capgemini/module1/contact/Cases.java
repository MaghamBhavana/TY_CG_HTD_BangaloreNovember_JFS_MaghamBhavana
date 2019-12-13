package com.capgemini.module1.contact;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.factoryclass.FactoryClass;
import com.capgemini.module1.dto.Mobile;
import com.capgemini.module1.services.PhoneAppSer;

public class Cases {
	static PhoneAppSer ser= FactoryClass.instanceOfServ();
	static Scanner sc=new Scanner(System.in);
	public static void showAllContacts()
	{
		List<Mobile> l=ser.getAllContacts();
		if(l!=null)
		{
			for (Mobile mobile : l) {
				System.out.println(mobile);
			}
		}

	}
	public static void searchForContact()
	{
		System.out.println("Enter the name");
		String name=sc.next();
		Mobile l=ser.singleContact(name);
		if(l!=null)
		{
			while(true)
			{
				System.out.println("1.call\n2.message\n3.back\n4.exit");
				int ch=sc.nextInt();
				switch (ch) 
				{
				case 1:System.out.println("calling---------");
				break;
				case 2:System.out.println("Now u can send the msg--");
				break;
				case 3:System.out.println("Back to menu");
				PhoneMenu.main(null);
				break;
				case 4:System.exit(0);
				}

			}
		}
		else
		{
			System.err.println("Sorry,Couldn't find the contact---");
		}
	}
	public static void operateContact()
	{
		while(true)
		{
			System.out.println("1.addContact/n2.deleteContact/n3.editContact/n4.exit");
			int ch=sc.nextInt();
			Mobile mobile=new Mobile();
			switch(ch)
			{
			case 1:System.out.println("Now you can add the contact----");
			System.out.println("Enter the Name----");
			mobile.setName(sc.next());
			System.out.println("Enter the Number---");
			mobile.setNumber(sc.nextLong());
			System.out.println("Enter th GroupName---");
			mobile.setGroup(sc.next());


			if(ser.addContact(mobile))
			{
				System.out.println("Contact added---");
			}
			else
			{
				System.err.println("Something went wrong");
			}
			break;
			case 2:System.out.println("Now you can delete the contact-----");
			System.out.println("Enter the name to delete");
			mobile.setName(sc.next());
			if(ser.deleteContact(mobile.getName()))
			{
				System.out.println("Contact is deleted successfully---");
			}
			else
			{
				System.err.println("Contact is not deleted. Please, do it again.");
			}
			break;
			case 3:System.out.println("Now you can edit the Number---");
			System.out.println("Enter the name to edit");
			mobile.setName(sc.next());
			System.out.println("Enter the new Number");
			mobile.setNumber(sc.nextLong());
			
			if(ser.editContact(mobile.getName(), mobile.getNumber()))
			{
				System.out.println("edited successfully...");
			}
			else
			{
				System.err.println("please, try again");
			}
			case 4:System.exit(0);
			}
		}

	}

}
