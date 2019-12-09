package edu.capgemini.looseandtightcoupling;

public class ATM {
	public static void main(String[] args) {
		Card c=new Card();
		HDFC h=new HDFC();
		SBI s=new SBI();
		Bank b1=new Bank();
		c.collectMoney(s);
	}
}
