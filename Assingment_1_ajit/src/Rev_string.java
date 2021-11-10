import java.util.Scanner;
 public class Rev_string
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a new string - ");
        String str = sc.nextLine();
        
        
        String rev = " ";
        
        
        int n = str.length();
        for(int i=n-1; i>=0; i--)
        {
            rev = rev + str.charAt(i);
        }
      
      System.out.println(rev);
    }
}



