package com.capgemini.multithreading;

public class Thread4 {
	public static void main(String[] args) {
		
		System.out.println("main start");
		IRCTC i=new IRCTC();
		User1 u=new User1(i);
		u.start();
		User1 u1=new User1(i);
		u1.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		i.leaveMe();
		System.out.println("main end");
	}

}
