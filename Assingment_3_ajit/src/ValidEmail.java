import java.util.Scanner;

public class ValidEmail
{
	public static Boolean CheckEmail(String mail)
	{
		String contain = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
				return mail.matches(contain);
	}

	public static void main(String args[])
	{
		
		String mail ;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a Email Address - ");
		mail = sc.nextLine();
		System.out.println();
		if(CheckEmail(mail))
		{
			System.out.println("[ Email is valid!! ] ");
		}
		else
		{
			System.out.println("[ Email is InValid!! ]");
		}
		
	}
}