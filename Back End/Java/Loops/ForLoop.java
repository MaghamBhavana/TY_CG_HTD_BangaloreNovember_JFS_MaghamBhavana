class ForLoop
{
	public static void main(String[] args)
	{
		for(int i=0;i<10;i++)
		{
			System.out.println("value is "+i);
		}
		System.out.println();
		for(int i=0;i<10;i++)
		{
			if(i==4)
			{
			continue;
			}
		System.out.println("Value is "+i);
		}
		System.out.println();
		for(int i=0;i<10;i++)
		{
			if(i==4)
			{
			break;
			}
		System.out.println("Value is "+i);
		}

		System.out.println();
		for(int i=9;i>=0;i--)
		{
		System.out.println("value is "+i);
		}
	}
}