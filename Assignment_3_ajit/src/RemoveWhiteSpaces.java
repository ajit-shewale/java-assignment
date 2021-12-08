import java.util.Scanner;

public class RemoveWhiteSpaces
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a String - ");
		String str =sc.nextLine();
		
		char[] cArray = str.toCharArray();
		 StringBuffer sb = new StringBuffer();  
	        for (int i = 0; i < cArray.length; i++)
	        {  
	            if ((cArray[i] != ' '))
	            {  
	                sb.append(cArray[i]);  
	            }  
	        }  
	        String newString = sb.toString(); 
	        System.out.print("String without spaces - ");
	        System.out.println(newString);  
		
	}
}