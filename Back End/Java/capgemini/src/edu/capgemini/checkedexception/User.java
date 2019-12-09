package edu.capgemini.checkedexception;

public class User {
	public static void main(String[] args) {
		IRCTC i1=new IRCTC();
		Paytm p=new Paytm(i1);
		p.bookTicket();
	}
}
