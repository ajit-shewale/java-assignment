import java.io.Serializable;
import java.util.Collection;

public class Library implements Serializable
{
	private List<Book> bookCollection;
	public Library()
	{
		bookCollection = new ArrayList<Book>();
	}
	
	public void addBook(Book book)
	{
		collection.add(book);
	}
	
	public String toStirng() 
	{
		String total = "\n";
		for(int i=0;i<bookCollection.size();i++)
		{
			Book b = collection.get(i);
			total = total + b.toString();
		}
		return total;
	}
}
