import java.util.Scanner;
public class CountVowelsConsonants
{
	public static void main(String args[])
	{
		String str;
		int countV=0,countC=0,i;
		System.out.println("Enter a String - ");
		Scanner sc=new Scanner(System.in);
		str=sc.nextLine();
		int n=str.length();
		for(i=0;i<n;i++)
		{
			if((str.charAt(i)=='a')||(str.charAt(i)=='e')||(str.charAt(i)=='i')||(str.charAt(i)=='o')||(str.charAt(i)=='u'))
			{
				countV++;
			}
			else if(str.charAt(i)==' ')
			{
				continue;
			}
			else
			{
				countC++;
			}
		}
		System.out.println("Total vowels  in the given string - "+countV);
		System.out.println("Total consonants in the given string - "+countC);
	}


}
