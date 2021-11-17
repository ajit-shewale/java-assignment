import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FindEvenNumbers
{
	static void EvenNumbers(ArrayList<Integer> integerList)
	{
		System.out.print("Even numbers from list are  - ");
		List<Integer> evenList = integerList.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
		System.out.println(evenList); // taking only even numbers from list
	}

	public static void main(String args[])
	{
		ArrayList<Integer> inputList = new ArrayList<Integer>(); // taking arraylist.
		int sizeofList;
		System.out.println("Enter number of elements for list - ");
		Scanner sc = new Scanner(System.in);
		sizeofList = sc.nextInt();
		System.out.println("Enter " + sizeofList + " number of elements - ");
		for (int i = 0; i < sizeofList; i++) {
			inputList.add(sc.nextInt()); // taking input from user.
		}
		System.out.println("Input List - " + inputList);
		System.out.println();
		EvenNumbers(inputList); // calling method
	}

}
