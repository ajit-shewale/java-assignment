import java.util.Scanner;
public class Delimeter
{
	 static int[] a= new int[20];

	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of elements for array - ");
		int n = sc.nextInt();
		System.out.println("Enter array elements - ");
		for (int i = 0; i < n; i++)
		{
			a[i] = sc.nextInt();
		}
		System.out.println("Array Enterd - ");
		for (int i = 0; i < n; i++)
		{
			System.out.print("|");
			System.out.print(a[i]);
			System.out.print("|");
		}
		System.out.println("\nEnter deleimeter - ");
		int d = sc.nextInt();
		
		for(int i=0;i<d;i++)
		{
			int carry = a[0];
			for (int j = 0; j < n; j++)
			{
				a[j]=a[j+1];
			}
			a[n-1]=carry;
		}
		System.out.println();
		System.out.println("New Array - ");
		for (int i = 0; i < n; i++)
		{
			System.out.print("|");
			System.out.print(a[i]);
			System.out.print("|");
		}
		
	}
}