package edu.capgemini.objectclass;

public class TestAnimal {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		AnimalGetClassMethod a=new AnimalGetClassMethod("pinky");
		Class c=a.getClass();
		System.out.println(c);
		AnimalGetClassMethod d2= (AnimalGetClassMethod) c.newInstance();
		System.out.println(d2.name);
		//Class c2= Class.forName("AnimalGetClassMethod");
		//System.out.println(c2);
		
	}
}
