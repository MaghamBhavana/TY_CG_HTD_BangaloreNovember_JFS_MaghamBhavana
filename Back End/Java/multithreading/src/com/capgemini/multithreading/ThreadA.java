package com.capgemini.multithreading;

public class ThreadA extends Thread{
	
	@Override
	public void run() {
		for(int i=0; i<4; i++)
		{
			System.out.println(i);
		}
		
	}

}
