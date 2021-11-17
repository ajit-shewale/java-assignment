import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class DuplicateElements
{
	static void duplicate(ArrayList<Integer> integerList)
	{
		System.out.println("Duplicate elemets are - ");
		Set<Integer> set = new HashSet<>(); // taking a set so the duplicate elements cant store in it.
		for (int i : integerList) {
			if (set.add(i) == false) // checking the elements are duplicate or not.
				System.out.println(i);
		}
	}

	public static void main(String args[])
	{
		ArrayList<Integer> inputList = new ArrayList<Integer>(); // taking array list.
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
		duplicate(inputList); // calling the duplicate method.
	}
}