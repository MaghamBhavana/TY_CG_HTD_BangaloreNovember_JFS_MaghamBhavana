package com.capgemini.multithreading;

public class PVR 
{
	synchronized void confirmTicket()
	{
		for(int i=0;i<4;i++)
		{
			System.out.println(i);
//			try 
//			{
//				Thread.sleep(200);
//			} catch (InterruptedException e) 
//			{
//				e.printStackTrace();
//			}
			try
			{
				wait();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	synchronized void leaveMe()
	{
		System.out.println("Notify called");
		notify();
	}
	
}
