package com.capgemini.multithreading;

public class IRCTC {
	
	synchronized void confirmTicket()
	{
		for(int i=0;i<5;i++)
		{
			System.out.println(i);
			
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	synchronized void leaveMe()
	{
		System.out.println("Calling notify");
		notifyAll();
	}

}
