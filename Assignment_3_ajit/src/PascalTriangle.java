import java.util.Scanner;
class PascalTriangle
{
    public static void main(String args[])
    {
	    int row,c=1,space,i,j;
	    System.out.println("Enter number of Rows -  ");
	    Scanner sc=new Scanner(System.in);
	    row=sc.nextInt();
	    for(i=0;i<row;i++)
	    {
	        for(space=1;space<=row-i;space++)
	        System.out.print("  ");
	        for(j=0;j<=i;j++)
	        {
	            if (j==0||i==0)
	                c=1;
	            else
	               c=c*(i-j+1)/j;
	            System.out.printf("%4d",c);
	        }
	        System.out.println("\n");
	    }
    }
}