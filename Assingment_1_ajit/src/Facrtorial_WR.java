import java.util.Scanner;

public class Facrtorial_WR
{
	public static void main(String args[])
	{
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a Number - ");
		int num = sc.nextInt();
		int fact = num;
		for(int i=num-1; i>0; i--)
		{
			fact = fact*i ; 
		}
		
		System.out.println("Factorial of "+num+"is = "+fact);
	}
}