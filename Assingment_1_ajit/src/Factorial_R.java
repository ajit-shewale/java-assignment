import java.util.Scanner;

public class Factorial_R
{
	int fun(int num)
	{
		if(num != 0)
		{
			return num * fun(num-1);
		}		
		else
		{
			return 1;
		}
	}
	
	public static void main(String args[])
	{
		System.out.println("Enter a Number - ");
		Scanner sc =  new Scanner(System.in);
		int num = sc.nextInt();
	
		
		Factorial_R r = new Factorial_R();
		int fact = r.fun(num);
		
		System.out.print("Factorial of "+num+" is "+fact);
	}

}
