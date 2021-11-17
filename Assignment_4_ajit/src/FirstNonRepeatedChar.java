import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Scanner;

public class FirstNonRepeatedChar
{
	static void nonRepeatedChar(List<String> string)
	{
		System.out.print("The first  Nonrepeated character - ");
		char[] charArray = string.toString().toCharArray(); // converting string to chararray
		int i = 1;
		List<Character> temp = new ArrayList<Character>(); // taking array list to store first non repeated character
		while (i < charArray.length - 1) {
			if (charArray[i] != ' ') {
				temp.add(charArray[i]);
			}
			i++;
		}

		List<Character> nonRepeatedChar = temp.stream().filter(x -> Collections.frequency(temp, x) < 2).limit(1)
				.collect(Collectors.toList()); // checking the frequency of the characters.
		System.out.println(nonRepeatedChar);
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		List<String> inputString = new ArrayList<String>(); // taking a string array list
		System.out.println("Enter a String - ");
		inputString.add(sc.nextLine());
		System.out.println("Input String - " + inputString);
		nonRepeatedChar(inputString); // calling a method
	}
}