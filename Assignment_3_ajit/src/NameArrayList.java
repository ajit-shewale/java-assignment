import java.util.ArrayList;
import java.util.Scanner;

public class NameArrayList
{
	public static void main(String args[])
	{
		int n = 5;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter "+n+" string elements - ");
		ArrayList<String> List = new ArrayList<>();
		for(int i=0;i<n;i++)
		{
			List.add(i,sc.nextLine());
		}
		System.out.println();
		System.out.println("Array List using for loop -");
		for(int i=0;i<n;i++)
		{
			System.out.print(List.get(i)+" "); 
		}System.out.println();
		System.out.println("Array List using while loop -");
		int i=0;
		while( i<n )
		{
			System.out.print(List.get(i)+" "); 
			i++;
		}System.out.println();
		System.out.println("Array List using Advanced for loop -");
		
		for(String k:List) 
		{
			System.out.print(k+" "); 
		}
	}
}