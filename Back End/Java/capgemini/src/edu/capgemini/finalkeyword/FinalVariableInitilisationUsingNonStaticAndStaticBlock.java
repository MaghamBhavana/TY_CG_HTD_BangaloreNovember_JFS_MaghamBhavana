package edu.capgemini.finalkeyword;

public class FinalVariableInitilisationUsingNonStaticAndStaticBlock {

	final int x;
	static final double PI;
	public FinalVariableInitilisationUsingNonStaticAndStaticBlock() {
		System.out.println("constructor One");
	}
	public FinalVariableInitilisationUsingNonStaticAndStaticBlock(int x)
	{
		System.out.println("constructor Two");
	}
	{
		this.x=30;
		//System.out.println("Non static block initilisation "+x);
	}
	static
	{
		System.out.println("Static Block");
		PI=3.142;
		System.out.println("Using static block initilisation "+PI);
	}
}
