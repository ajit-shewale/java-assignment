import java.util.Scanner;

public class Ascending
{
	public static void main(String args[])
	{
		int num, temp;
		System.out.println("Enter  no of Array element-");
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		int inputArray[] = new int[num];
		System.out.println("Enter array Elements -");
		for (int i = 0; i < num; i++) {
			inputArray[i] = sc.nextInt();
		}
		System.out.println("The Entered Array -");
		for (int i = 0; i < num; i++) {
			System.out.print("|");
			System.out.print(inputArray[i]);
			System.out.print("|");
		}
		for (int i = 0; i < num; i++) {
			for (int j = i + 1; j < num; j++) {
				if (inputArray[i] > inputArray[j]) {
					temp = inputArray[i];
					inputArray[i] = inputArray[j];
					inputArray[j] = temp;
				}
			}
		}
		System.out.println();
		System.out.println("Sorted Array in Ascending orderr - ");
		for (int i = 0; i < num; i++) {
			System.out.print("|");
			System.out.print(inputArray[i]);
			System.out.print("|");
		}
	}
}
