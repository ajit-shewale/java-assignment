import java.util.ArrayList;
import java.util.Scanner;

public class TotalElements
{
	static void sizeOfList(ArrayList<Integer> list)
	{
		System.out.println("Total elemets in list are - " + list.size()); // calculating size of list
	}

	public static void main(String args[])
	{
		ArrayList<Integer> inputList = new ArrayList<Integer>(); // taking integer list.
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
		sizeOfList(inputList); // calling the method.
	}
}
