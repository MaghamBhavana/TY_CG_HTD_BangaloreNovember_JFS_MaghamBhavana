package edu.capgemini.accessspecifiers;

public class TestDefaultAccess {

	public static void main(String[] args) {
		
		DefaultAccess a=new DefaultAccess(10);
		a.details();//this can access only with in the class,package not outside the package

	}

}
