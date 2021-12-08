import java.util.Scanner;
public class reverse_number
{
	public static void main(String args[])
	{
		int remender=1;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a number - ");
		int inputNumber = sc.nextInt(); //taking a number from user.
	
		
		System.out.println("Reverese of given number - ");
		
		for(int i=0;inputNumber!=0;i++)
		{
			remender = inputNumber%10;
			System.out.print(remender); //taking remender from number and printing.
			inputNumber = inputNumber/10;		
		}
		
	}
}