import java.util.Scanner;
class LeapYear
{
	public static void main(String args[])
	{
		
		System.out.println("Enter a year - ");
		Scanner sc=new Scanner(System.in);
		int year=sc.nextInt();
		if(((year%4==0)&& (year%100!=0))||(year%400==0))
		{
			System.out.println("This is a leap year");
		}
		else
		{
			System.out.println("This is not a leap year");
		}
	}

}