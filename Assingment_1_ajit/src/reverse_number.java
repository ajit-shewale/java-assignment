import java.util.Scanner;
public class reverse_number
{
	public static void main(String args[])
	{
		int rem=1;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a number - ");
		int num = sc.nextInt();
		
		System.out.println("Reverese of given number - ");
		
		for(int i=0;num!=0;i++)
		{
			rem = num%10;
			System.out.print(rem);
			num = num/10;
			
		}
		
	}
}