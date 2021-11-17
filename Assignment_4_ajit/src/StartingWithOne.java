import java.util.ArrayList;
import java.util.Scanner;

public class StartingWithOne
{
	static void startWithOne(ArrayList<Integer> list)
	{
		ArrayList<Integer> oneList = new ArrayList<Integer>();
		for (int i : list) {
			String temp = String.valueOf(i);
			if (temp.startsWith("1") == true) // checking if it is starting with 1 or not
				oneList.add(i);
		}
		System.out.println(oneList);
	}

	public static void main(String[] args)
	{

		ArrayList<Integer> inputList = new ArrayList<Integer>();// taking a list.
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
		startWithOne(inputList); // calling the method.
	}
}
