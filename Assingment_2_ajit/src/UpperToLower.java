import java.util.Scanner;
public class UpperToLower
{
	public static void main(String args[])
	{
		String str;
		int i;
		System.out.println("Enter a String - ");
		Scanner sc=new Scanner(System.in);
		str=sc.nextLine();
		int n=str.length();
		System.out.println("New String - ");
		for(i=0;i<n;i++)
		{
			if(Character.isLowerCase(str.charAt(i)))
			{
				System.out.print(Character.toUpperCase(str.charAt(i)));
			}
			else if(Character.isUpperCase(str.charAt(i)))
			{
				System.out.print(Character.toLowerCase(str.charAt(i)));
			}
	
			else
			{
				System.out.print(str.charAt(i));
			}
		}
	}
}



