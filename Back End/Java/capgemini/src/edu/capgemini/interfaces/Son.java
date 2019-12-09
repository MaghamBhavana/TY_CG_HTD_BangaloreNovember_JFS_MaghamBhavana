package edu.capgemini.interfaces;

public class Son implements Father1,Father2{

	@Override
	public void house()
	{
		Father2.super.house();
	}
	

}
