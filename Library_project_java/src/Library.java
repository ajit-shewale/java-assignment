import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Library
{
	Scanner sc =new Scanner(System.in);
	ArrayList<Book> bookCollection = new ArrayList<>();
	
	public void bookSpec()
	{
		System.out.println("\nId:");
		int id = sc.nextInt();
		System.out.println("\nTitle:");
		String title = sc.nextLine();
		System.out.println("\nAuthor:");
		String author = sc.nextLine();
		System.out.println("\nPrice:");
		double price = sc.nextDouble();
		
		Book singleBook = new Book(id,title,author,price);
		
		addBook(singleBook);
	}
	public void addBook(Book singleBook)
	{
		bookCollection.add(singleBook);
	}
	public void removeBook()
	{
		System.out.print("Enter book id:");
		int id = sc.nextInt();
		for (int i = 0; i < bookCollection.size(); i++) 
		 {
			Book tempBook = bookCollection.get(i);
			
			
	            if(tempBook.getId()==id)
	            {
	            	
	            	bookCollection.remove(i);
	            	System.out.println("Removed Successfully !!!");
	            }
	            else
	            	System.out.println("Invalid  ID !!!");
		 }
	}
	public void showLibrary()
	{
		 for (int i = 0; i < bookCollection.size(); i++) 
		 {
//	            System.out.println(bookCollection.get(i) + " ");
			 Book tempBook = bookCollection.get(i);
				System.out.println(tempBook.toString());
		 }

	}
}