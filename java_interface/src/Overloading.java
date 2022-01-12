
public class Overloading {

	static String  singers(String name1)
	{
		return "Solo"; 
	}
	
	static String  singers(String name1, String name2)
	{
		return "Duo"; 
	}
	
	static String  singers(String name1, String name2,  String name3)
	{
		return "Chores"; 
	}
	
	static String  singers(String[] singerlist)
	{
		return "BAND!!!!!"; 
	}


	public static void main(String[] args) {
		System.out.println(Overloading.singers("arijit"));  
		System.out.println(Overloading.singers("arijit","amar")); 
		System.out.println(Overloading.singers("arijit","rohit","amar")); 
		
		System.out.println(Overloading.singers(new String[]  {"ajit","rakesh"}) ); 
	}

}
