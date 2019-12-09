package edu.capgemini.accessspecifiers;

public class PrivateAccessSpecifier {
	
	private int x;
	public PrivateAccessSpecifier(int x) {
		this.x=x;
	}
	private void method()
	{
		System.out.println("value is "+x);//we acn access only with in the class it is accessable here
	}
	
	public static void main(String[] args) {
		PrivateAccessSpecifier p=new PrivateAccessSpecifier(10);
		p.method();
	}

}
