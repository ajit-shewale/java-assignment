import java.util.Scanner;

public class Facrtorial_WR
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a Number - ");
		int number = sc.nextInt();
		int factorial = number;
		for (int i = number - 1; i > 0; i--) {
			factorial = factorial * i;
		}
		System.out.println("Factorial of " + number + "is = " + factorial);
	}
}