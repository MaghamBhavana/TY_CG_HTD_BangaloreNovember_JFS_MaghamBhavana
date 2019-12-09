package edu.capgemini.looseandtightcoupling;

public class Card {
	void collectMoney(Bank b)
	{
		b.insert();
		b.withDraw();
	}

}
