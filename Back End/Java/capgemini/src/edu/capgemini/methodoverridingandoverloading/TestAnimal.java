package edu.capgemini.methodoverridingandoverloading;

public class TestAnimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lion l=new Lion();
		l.eat();
		Cat c=new Cat();
		c.eat();
		Animal a=new Lion();//Upcasting
		a.eat();
		Animal a1=new Cat();//Upcasting
		a1.eat();
	}

}
