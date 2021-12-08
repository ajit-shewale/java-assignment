import java.util.Scanner;
public class Desending
{
	public static void main(String args[])
	{
		int n,temp;
		System.out.println("Enter  no of Array element-");
		Scanner sc=new Scanner(System.in);
	     n=sc.nextInt();
		int a[]=new int[n];
		System.out.println("Enter array Elements -");
		for (int i = 0; i < n; i++) 
		{
			a[i]=sc.nextInt();
		}
	System.out.println("The Entered Array -");
		for (int i = 0; i < n; i++)
		{
			System.out.print("|");
			System.out.print(a[i]);
			System.out.print("|");
		}
		        for(int i=0;i<n;i++)
		        {
		         for(int j=i+1;j<n;j++)
				  {
						if(a[i]<a[j])
						{
						temp=a[i];
						a[i]=a[j];
						a[j]=temp;
						}
				  }
		        }
		        System.out.println();
			System.out.println("Sorted Array in Descending order - ");
			for (int i = 0; i < n; i++)
			{
				System.out.print("|");
				System.out.print(a[i]);
				System.out.print("|");
			}
		}
}