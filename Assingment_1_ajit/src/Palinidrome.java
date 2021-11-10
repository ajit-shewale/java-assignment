
	import java.util.Scanner;
	 public class Palinidrome
	{
	    public static void main(String args[])
	    {
	        @SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
	        System.out.println("Enter a string - ");
	        String str = sc.nextLine();
	        
	        String rev ="";
	        
	        int n = str.length();
	        
	        for(int i=n-1; i>=0; i--)
	        {
	            rev = rev + str.charAt(i);
	        }
	        
	        if(str.equals(rev))
	        System.out.println("String is pallinidrome");
	        else
	        System.out.println("String is not pallinidrome");
	    }
	}
