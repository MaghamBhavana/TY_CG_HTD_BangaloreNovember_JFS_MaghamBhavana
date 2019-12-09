package edu.capgemini.finalkeyword;

public class TestNonStaticBlock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FinalVariableInitilisationUsingNonStaticAndStaticBlock v=new FinalVariableInitilisationUsingNonStaticAndStaticBlock();
		System.out.println("non static block constuctor 1 "+v.x);
		FinalVariableInitilisationUsingNonStaticAndStaticBlock v1=new FinalVariableInitilisationUsingNonStaticAndStaticBlock(20);
		System.out.println("non static block consturctor 2 "+v1.x);
		
	}

}
