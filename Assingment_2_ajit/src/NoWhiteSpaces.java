import java.util.Scanner;
public class NoWhiteSpaces 
{
		public static void main(String args[])
		{
			String str;
			int i;
			System.out.println("Enter a String - ");
			Scanner sc=new Scanner(System.in);
			str=sc.nextLine();
			int n=str.length();
			System.out.println("String after removing white spaces - ");
			for(i=0;i<n;i++)
			{
				if(str.charAt(i)==' ')
				{
					continue;
				}
				else
				{
					System.out.print(str.charAt(i));
				}
			}
		}
	}

