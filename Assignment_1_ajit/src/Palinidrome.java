
import java.util.Scanner;

public class Palinidrome
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a string - ");
		String inputString = sc.nextLine();

		String reverse = " ";

		int stringSize = inputString.length();
System.out.println(stringSize);
		for (int i = stringSize; i >0; i--) {
			reverse = reverse + inputString.charAt(i);
		}

		if (inputString.equals(reverse))
			System.out.println("String is pallinidrome");
		else
			System.out.println("String is not pallinidrome");
	}
}
