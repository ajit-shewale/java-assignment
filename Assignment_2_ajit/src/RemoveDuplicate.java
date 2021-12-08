import java.util.Scanner;
public class RemoveDuplicate
{
	static int[] a = new int[20];
	
	public static void main(String args[])
	 {
	 	int count = 0 ;
	 	Scanner sc = new Scanner(System.in);
	 	System.out.println("Enter number of elemrnts in array - ");
	 	int n = sc.nextInt();
		System.out.println("Enter array Elements -");
		for (int i = 0; i < n; i++) 
		{
			a[i]=sc.nextInt();
		}
		System.out.println("Array Enterd - ");
		for (int i = 0; i < n; i++)
		{
			System.out.print("|");
			System.out.print(a[i]);
			System.out.print("|");
		}

	 	for (int i = 0; i <n; i++)
	 	{
	 		count=0;
	 		for (int j = 0; j < n; j++)
	 		{
	 			if(a[i] == a[j])
	 			{
	 				count++;
	 			}
	 		}
	 		if(count>1)
	 		{
	 			for (int k= i; k < n-1; k++)
	 			{
	 				a[k]=a[k+1];
				}
	 			n=n-1;
	 		}
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