import java.io.Serializable;

public class Book implements Serializable 
{
	private int id;
	private String title,author;
	private double price;
	
	public Book()
	{
		id=0;
		title=null;
		author=null;
		price=0;
	}
	
	Public Book(int id,String title, String author,double price)
	{
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
	}
	
	public String toString()
	{
		return "\nTitle: "+ title +"\nAuthor: "+ author +"\nId: "+ id +
				"\nPrice: "+ price +"\n";
	}
}
