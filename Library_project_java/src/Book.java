public class Book 
{
	private int id;
	private String title;
	private String author;
	private double price;
	
	public Book()
	{
		id=0;
		title=null;
		author=null;
		price=0;
	}
	
	public Book(int id,String title, String author,double price)
	{
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
	}

	public int getId() {
		return id;
	}
	public String toString(){
		return"Book{"+"Id: "+id+" Title: "+title+" Author: "+author+" Price: "+price+"}";
	}
	
}
