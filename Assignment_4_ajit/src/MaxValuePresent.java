import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MaxValuePresent
{
	static void maxValue(ArrayList<Integer> list)
	{
		System.out.println("Max element in given list - " + Collections.max(list)); //checking max element through max method in collection
	}

	public static void main(String[] args)
	{
		ArrayList<Integer> inputList = new ArrayList<Integer>(); //taking a integer list
		int sizeofList;
		System.out.println("Enter number of elements for list - ");
		Scanner sc = new Scanner(System.in);
		sizeofList = sc.nextInt();
		System.out.println("Enter " + sizeofList + " number of elements - ");
		for (int i = 0; i < sizeofList; i++) {
			inputList.add(sc.nextInt());	//taking input from user.
		}
		System.out.println("Input List - " + inputList);
		System.out.println();
		maxValue(inputList); //calling the method.
	}
}