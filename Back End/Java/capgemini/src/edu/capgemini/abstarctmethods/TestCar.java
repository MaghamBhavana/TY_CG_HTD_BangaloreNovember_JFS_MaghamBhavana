package edu.capgemini.abstarctmethods;

public class TestCar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car c1=new Car();
		c1.start();
		c1.stop();
		System.out.println("------------------");
		Vehicle v=new Car();
		v.start();
		v.stop();
	}

}
