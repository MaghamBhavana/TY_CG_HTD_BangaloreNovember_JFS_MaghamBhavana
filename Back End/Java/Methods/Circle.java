class Circle
{
	static double areaCircle(int r)
	{
		double areaCircle=3.142*r*r;
		return areaCircle;
	}
	static double perimeterCircle(int r)
	{
		double perimeterCircle=2*3.142*r;
		return perimeterCircle;
	}
	static int areaSquare(int a)
	{
		int areaSquare=a*a;
		return areaSquare;
	}
	static int perimeterSquare(int a)
	{
		int perimeterSquare=4*a;
		return perimeterSquare;
	}
	static double areaRectangle(int a,int b)
	{
		double areaRectangle=a*b;
		return areaRectangle;
	}
	static double perimeterRectangle(int a,int b)
	{
		double perimeterRectangle=0.5*(a+b);
		return perimeterRectangle;
	}
	public static void main(String args[])
	{
		double result=areaCircle(5);
		double result1=perimeterCircle(6);
		int areasqu=areaSquare(6);
		int perisqu=perimeterSquare(6);
		double areaRec=areaRectangle(5,10);
		double periRec=perimeterRectangle(5,10);
		System.out.println("Area of the rectangle is= "+areaRec);
		System.out.println("Perimeter of the rectangle is= "+periRec);
		System.out.println("Perimeter of the square is= "+perisqu);
		System.out.println("Area of the square is= "+areasqu);
		System.out.println("Area of the circle is= "+result);
		System.out.println("Perimetre of the circle is= "+result1);
		
	}
}