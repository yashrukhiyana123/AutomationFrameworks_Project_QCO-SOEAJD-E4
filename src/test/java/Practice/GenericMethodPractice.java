package Practice;

public class GenericMethodPractice 
{
	public static void main(String[] args) // caller
	{
		// Hard Coded

		/*
		int a = 10;
		int b = 20;
		int c = a+b;
		
		System.out.println(c);
		*/

		add(20,30);
		add(100,300);
		int sum = add(100,3);

		System.out.println(sum);
	}
	public static int add(int a, int b) //called
	{
		//Generic Method & Reusable Method
		int c = a+b;
		return c;
	}
}
