import java.util.Scanner;
class PrimeNumber
{
	public static void main(String args[])
	{
		int flag=0;
		System.out.println("Enter a number - ");
		Scanner sc=new Scanner(System.in);
		int number=sc.nextInt();
		for(int i=2;i<number;i++)
		{
			 flag=0;
			if(number%i==0)
			{
			flag=1;
			break;
			}
		}	
		if(flag==0)
		{
			System.out.println("It is a prime number..");
		}
		else
		{
			System.out.println("It is not a prime number..");
		}
	}

}