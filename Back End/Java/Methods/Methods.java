class Methods
{
	public static void main(String[] args)
	{
	   add(20,90);
	   add(40,60);
	   subtract(100,90);
	   mul(10,20);
	   div(20,10);
	   mod(200,10);
	}
	static void add(int a,int b)
	{
	   System.out.println("Sum of a and b is= "+(a+b));
		return;//Just writting the return statement but we are not writting any thing.
	}
	static void subtract(int a,int b)
	{	
	   System.out.println("Sub of a and b is= "+(a-b));
	}
	static void mul(int a,int b)
	{
	   System.out.println("Multiplication of a and b is= "+(a*b));
	}
	static void div(int a,int b)
	{
	   System.out.println("Division of a and b is= "+(a/b));
	}
	static void mod(int a,int b)
	{
	    System.out.println("Modulo of a and b is= "+(a%b));
	}
}