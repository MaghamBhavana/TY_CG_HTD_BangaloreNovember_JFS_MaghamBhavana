package com.capgemini.multithreading;

public class Thread1{
	public static void main(String[] args) {
		System.out.println("Main started");
		ThreadA t = new ThreadA();
		t.start();
		System.out.println("Main ended");
	}

}
