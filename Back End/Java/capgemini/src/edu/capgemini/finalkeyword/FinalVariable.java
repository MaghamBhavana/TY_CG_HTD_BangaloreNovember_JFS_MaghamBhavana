package edu.capgemini.finalkeyword;

public class FinalVariable {
	final double PI;
	public FinalVariable(double PI) {
		this.PI=PI;
	}
	public FinalVariable(int a,double PI)
	{
		this.PI=PI;
	}
	void print()
	{
		System.out.println(PI);
	}

}
