import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class AscendingSort
{
	static void sortList(ArrayList<Integer> list)
	{
		Collections.sort(list);// sorting the given list.
		System.out.println("Sorted List - " + list);
	}

	public static void main(String[] args)
	{
		ArrayList<Integer> inputList = new ArrayList<Integer>(); // taking arraylist.
		int sizeofList;
		System.out.println("Enter number of elements for list - ");
		Scanner sc = new Scanner(System.in);
		sizeofList = sc.nextInt();
		System.out.println("Enter " + sizeofList + " number of elements - ");
		for (int i = 0; i < sizeofList; i++) {
			inputList.add(sc.nextInt()); // taking inputs from user.
		}
		System.out.println("Input List - " + inputList);
		System.out.println();
		sortList(inputList); // calling the method.
	}
}