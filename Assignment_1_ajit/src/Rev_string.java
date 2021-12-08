import java.util.Scanner;

public class Rev_string
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a new string - ");
		String string = sc.nextLine(); // taking string from user.
		System.out.println("Input String - " + string);
		String reverse = " ";

		int stringSize = string.length();
		for (int i = stringSize - 1; i >= 0; i--) {
			reverse = reverse + string.charAt(i); // taking reverse character from string and adding to the new string
		}
		System.out.print("Reversed String - ");
		System.out.println(reverse.trim()); //printing the reverse string.
	}
}
