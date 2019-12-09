package edu.capgemini.abstarctmethods;

public class MainClass {

	public static void main(String[] args) {
		ShopKeeper s=new ShopKeeper(10000);
		s.m1();
		s.m2();
		
		System.out.println("Static data memeber "+Shop.cost);
	}

}
