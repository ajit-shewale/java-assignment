import java.util.Scanner;
public class countChar
{
	public static void main(String args[])
	{
		String str;
		int count=0,i;
		System.out.println("Enter a string - ");
		Scanner sc=new Scanner(System.in);
		str=sc.nextLine();
		int n=str.length();
		for(i=0;i<n;i++)
		{
			if(str.charAt(i)!=' ')
			{
				count++;
			}
		}
		System.out.println("Total Characters in ("+str+") - "+count);
	}
}


