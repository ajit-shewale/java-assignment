
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class ValidDate
{
	public static Boolean CheckDate(String date)
	{
		  boolean status = false;
	      String pattern = "(0?[1-9]|[12][0-9]|3[01])\\/(0?[1-9]|1[0-2])\\/([0-9]{4})";
	    boolean flag = false;
	    if (date.matches(pattern)) 
	    {
		      flag = true;
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyy");
			dateFormat.setLenient(false);
			try 
			{ 
				dateFormat.parse(date);	
				return true;
			} 
			catch (Exception e) 
			{
				return false;
			}
	    }
		return status;
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a Date in dd/mm/yyyy - ");
		String date = sc.nextLine();
		System.out.println();
		if(CheckDate(date) == true)
		{
			System.out.println("[ Date is valid!! ]");
		}
		else
		{
			System.out.println("[ Date is Invalid!! ]");
		}
	}
	
}