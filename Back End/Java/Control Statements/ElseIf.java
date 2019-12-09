class ElseIf
{
	public static void main(String args[])
	{
		int a=90;
		int b=899;
		int c=567;
		int d=356;
		if(a>b && a>c && a>d)
		System.out.println("A is greater");
		else if(b>c && b>d)
		System.out.println("B is greater");
		else if(c>d)
		System.out.println("C is greater");
		else
		System.out.println("D is greater");
	}
}