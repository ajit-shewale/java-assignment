import java.util.Scanner;

public class countChar
{
	public static void main(String args[])
	{
		String inputString;
		int count = 0, i;
		System.out.println("Enter a string - ");
		Scanner sc = new Scanner(System.in);
		inputString = sc.nextLine();
		int stringlength = inputString.length();
		for (i = 0; i < stringlength; i++) {
			if (inputString.charAt(i) != ' ') {
				count++;
			}
		}
		System.out.println("Total Characters in (" + inputString + ") - " + count);
	}
}
