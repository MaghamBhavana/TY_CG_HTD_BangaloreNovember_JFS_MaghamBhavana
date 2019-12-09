package edu.capgemini.objectclass;

public class TestPesron {
	public static void main(String[] args) throws Throwable {
		Person p=new Person("Balaram");
		//p.finalize();
		p=null;
		System.gc();//finalize method will be called automatically when we call System.gc().
		System.out.println("main method end");
		
	}

}
