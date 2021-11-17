import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Scanner;

public class FirstRepeatedChar
{
	static void repeatedChar(List<String> string)
	{
		System.out.print("The first repeated character - ");
		char[] charArray = string.toString().toCharArray(); // converting string to chararray.
		int i = 1;
		List<Character> temp = new ArrayList<Character>(); // taking another list to store first repeated character.
		while (i < charArray.length - 1) {
			if (charArray[i] != ' ') {
				temp.add(charArray[i]);
			}
			i++;
		}

		List<Character> repeatedChar = temp.stream().filter(x -> Collections.frequency(temp, x) > 1).limit(1)
				.collect(Collectors.toList());// checking frequency of the characters.
		System.out.println(repeatedChar);
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		List<String> inputString = new ArrayList<String>(); // taking a string arrylist.
		System.out.println("Enter a String - ");
		inputString.add(sc.nextLine()); // taking input from user.
		System.out.println("Input String - " + inputString);
		repeatedChar(inputString); // calling the method.
	}
}