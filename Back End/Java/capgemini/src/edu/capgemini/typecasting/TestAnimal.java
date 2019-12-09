package edu.capgemini.typecasting;

public class TestAnimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Animal a=new Dog();//upcasting of dog class
		a.eat();
		System.out.println("--------------");
		Dog d=(Dog) a;
		d.eat();
		d.walk();
		System.out.println("----------------");
		Animal a1=new Lion();
		a1.eat();
		System.out.println("----------------");
		Lion l=(Lion) a1;
		l.eat();
		l.run();

	}

}
