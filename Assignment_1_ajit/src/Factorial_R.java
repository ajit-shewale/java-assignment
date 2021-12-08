import java.util.Scanner;

public class Factorial_R
{
	int fun(int number)
	{
		if (number != 0) {
			return number * fun(number - 1);
		} else {
			return 1;
		}
	}

	public static void main(String args[])
	{
		System.out.println("Enter a Number - ");
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();

		Factorial_R r = new Factorial_R();
		int fact = r.fun(number);

		System.out.print("Factorial of " + number + " is " + fact);
	}

}
