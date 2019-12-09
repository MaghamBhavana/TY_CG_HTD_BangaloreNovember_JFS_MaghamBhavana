package edu.capgemini.accessspecifiers;

class DefaultAccess {
	
	int x;
	DefaultAccess(int x) {
		this.x=x;
	}
	void details()
	{
		System.out.println("value is "+x);//as it is default we can access with in the class
	}
}
