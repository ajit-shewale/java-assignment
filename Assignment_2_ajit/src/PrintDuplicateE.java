import java.util.Scanner;
public class PrintDuplicateE
{
	static int[] a = new int[20];
	
	public static void main(String args[])
	 {
	 	int count = 0 ,temp;
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
		
		for(int i=0;i<n-1;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(a[i]>a[j])
				{
					temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
		}
		 System.out.println();
		System.out.println("Duplicate Elements - ");
	 	for (int i = 0; i <n; i++)
	 	{
	 		count=0;
	 		for (int j = i+1; j < n; j++)
	 		{
	 			if(a[i] == a[j])
	 			{
	 				count++;
	 				i++;
	 			}
	 		}
	 		if(count>=1)
	 		{
	 			System.out.println(a[i]);
	 		}
	 	}
	 }
} 