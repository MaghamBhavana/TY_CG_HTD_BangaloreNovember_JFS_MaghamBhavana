package edu.capgemini.exceptionhandling;

public class TestOla {
	public static void main(String[] args) {
		
		ThrowKeyGoogleMap e=new ThrowKeyGoogleMap();
		Ola o=new Ola(e);
		
		o.find(null);
	}

}
