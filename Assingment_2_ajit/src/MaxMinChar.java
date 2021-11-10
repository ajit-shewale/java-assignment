import java.util.Scanner;
public class MaxMinChar
{
	static String str;
	static char max,min;
	static int maxCount=0, minCount=1,tempCount=0;
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a string - ");
		str = sc.nextLine();
		max = ' ';
		min = ' ';
		
		for (int i = 0; i < str.length(); i++) 
		{
			tempCount=0;
			for (int j = 0; j < str.length(); j++) 
			{
				if(str.charAt(i)==str.charAt(j))
				{
					tempCount++;
				}
			}
			if(tempCount>maxCount)
			{
				minCount = maxCount;
				min=max;
				max = str.charAt(i);
				maxCount=tempCount;
			}
			if(tempCount<minCount)
			{
				min=str.charAt(i);
			}
		}
		System.out.println("Minimum frequnecy Character - "+min);
		System.out.println("Maximum frequnecy Character - "+max);
	}
}
