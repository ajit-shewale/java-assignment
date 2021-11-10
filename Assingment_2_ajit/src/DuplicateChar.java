import java.util.Scanner;
public class DuplicateChar
{
	static String str;
	static int count=0;
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a string - ");
		str = sc.nextLine();
		System.out.println("Duplicate Characters - ");
		for (int i = 0; i < str.length(); i++) 
		{
			count=0;
			for (int j = 0; j < str.length(); j++)
			{
				if(str.charAt(i)==str.charAt(j))
				{
					count++;
				}
			}
			if(count>1)
			{
				System.out.println(str.charAt(i));
			}
		}
	}
}