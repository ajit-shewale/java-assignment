import java.util.Scanner;

public class CountVowelsConsonants
{
	public static void main(String args[])
	{
		String inputString;
		int countVowels = 0, countConsonants = 0, i;
		System.out.println("Enter a String - ");
		Scanner sc = new Scanner(System.in);
		inputString = sc.nextLine();
		int stringLength = inputString.length();
		for (i = 0; i < stringLength; i++) {
			if ((inputString.charAt(i) == 'a') || (inputString.charAt(i) == 'e') || (inputString.charAt(i) == 'i') || (inputString.charAt(i) == 'o')
					|| (inputString.charAt(i) == 'u') || (inputString.charAt(i) == 'A') || (inputString.charAt(i) == 'E')
					|| (inputString.charAt(i) == 'I') || (inputString.charAt(i) == 'O') || (inputString.charAt(i) == 'U')) {
				countVowels++;
			} else if (inputString.charAt(i) == ' ') {
				continue;
			} else {
				countConsonants++;
			}
		}
		System.out.println("Total vowels  in the given string - " + countVowels);
		System.out.println("Total consonants in the given string - " + countConsonants);
	}

}
