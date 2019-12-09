package com.capgemini.multithreading;

public class Thread3
{
	public static void main(String[] args) {
		
		System.out.println("Main started");
		PVR p = new  PVR();
		User u = new User(p);
		u.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		p.leaveMe();
		System.out.println("Main Ended");
	}

}
