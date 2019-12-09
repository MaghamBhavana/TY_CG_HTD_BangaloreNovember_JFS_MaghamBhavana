package edu.capgemini.interfaces;

public class TestBottel {
	public static void main(String[] args) {
		
		Fanta f=new Fanta();
		f.open();
		f.drink();
		f.juice();
		
		Pepsi p=new Pepsi();
		p.open();
		p.drink();
		p.juice();
		Bottel.fruit();
	}
}
