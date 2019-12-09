package edu.capgemini.looseandtightcoupling;

public class TestCat {
	public static void main(String[] args) {
		Cat c1=new Cat();
		Chips c2=new Chips();
		Lays l=new Lays();
		Kurkure k=new Kurkure();
		Bingo b=new Bingo();
		c1.feedFood(k);
	}
}
