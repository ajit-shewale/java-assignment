import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SumOfOdd
{
	static void EvenNumbers(ArrayList<Integer> integerList)
	{
		System.out.print("Sum of ODD Elments in list - ");
		List<Integer> List = integerList.stream().filter(n -> n % 2 != 0).collect(Collectors.toList());// checking odd
																										// elements
		int sumOfOdd = 0;
		for (Integer i : List) {
			sumOfOdd = sumOfOdd + i; // calculating sum of odd elements.
		}
		System.out.println(sumOfOdd);
	}

	public static void main(String[] args)
	{
		ArrayList<Integer> inputList = new ArrayList<Integer>(); // taking integer list
		int sizeofList;
		System.out.println("Enter number of elements for list - ");
		Scanner sc = new Scanner(System.in);
		sizeofList = sc.nextInt();
		System.out.println("Enter " + sizeofList + " number of elements - ");
		for (int i = 0; i < sizeofList; i++) {
			inputList.add(sc.nextInt()); // taking input from user
		}
		System.out.println("Input List - " + inputList);
		System.out.println();
		EvenNumbers(inputList); // calling the method.
	}

}
