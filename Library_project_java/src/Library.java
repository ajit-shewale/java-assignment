import java.util.ArrayList;
import java.util.Scanner;

public class Library
{
	Scanner sc =new Scanner(System.in);
	ArrayList<Book> bookCollection = new ArrayList<>();
	
	public void addBook()
	{
		System.out.println("\nId:");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("\nTitle:");
		String title = sc.nextLine();
		System.out.println("\nAuthor:");
		String author = sc.nextLine();
		System.out.println("\nPrice:");
		double price = sc.nextDouble();
		System.out.print("\nQuantity:");
		int quantity = sc.nextInt();
		
		Book singleBook = new Book(id,title,author,price,quantity);
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
		System.out.println("|______LIBRARY______|");
		 for (int i = 0; i < bookCollection.size(); i++) 
		 {
			 Book tempBook = bookCollection.get(i);
				System.out.println(tempBook.toString());
		 }

	}
	public void issueBook()
	{
		System.out.print("Enter book id:");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.print("\nEnter your Name -  ");
		String name = sc.nextLine();
		for (int i = 0; i < bookCollection.size(); i++) 
		 {
			Book tempBook = bookCollection.get(i);
			
	            if(tempBook.getId()==id)
	            {
	            	int tempQuant = tempBook.getQuantity();
	            	tempQuant--;
	            	tempBook.setQuantity(tempQuant);
	            	String title = tempBook.getTitle();
	            	System.out.println("Book ["+title+"] issued to [" +name+ "] successfully !!");
	            }
	            else
	            	{System.out.println("Invalid  ID !!!");}
		 }
		
	}
	public void returnBook()
	{
		System.out.print("Enter book id:");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.print("\nEnter your Name -  ");
		String name = sc.nextLine();
		for (int i = 0; i < bookCollection.size(); i++) 
		 {
			Book tempBook = bookCollection.get(i);
			
	            if(tempBook.getId()==id)
	            {
	            	int tempQuant = tempBook.getQuantity();
	            	tempQuant++;
	            	tempBook.setQuantity(tempQuant);
	            	String title = tempBook.getTitle();
	            	System.out.println("Book ["+title+"] returned from [" +name+ "] successfully !!");
	            }
	            else
	            	{System.out.println("Invalid  ID !!!");}
		 }
	}
}