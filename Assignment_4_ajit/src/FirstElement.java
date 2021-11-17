import java.util.ArrayList;
import java.util.Scanner;

public class FirstElement
{
	static void findFirst(ArrayList<Integer> list)
	{
		System.out.println("First element of list - " + list.get(0)); // taking only first element through get method
	}

	public static void main(String args[])
	{
		ArrayList<Integer> inputList = new ArrayList<Integer>(); // taking arraylist
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
		findFirst(inputList); // calling method
	}
}