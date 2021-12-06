import java.util.Scanner;

public class MainSystem
{
	static String fileName = null;
	static Library lib = new Library();
	static Scanner sc = new Scanner(System.in);
	static Boolean running = true;

	public static void main(String args[])
	{
		while(running)
		{
			System.out.println("\nEnter 0 for load a library." + "\nEnter 1 for save and quit" + " \nEnter 2 for show all books in library" + "\nEnter 3 for add book to library");
			int input = sc.nextInt();
			
		} 
	}
}
