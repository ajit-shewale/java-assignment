import java.util.*;

public class IteratehashMap
{
	public static void main(String args[])
	{
		HashMap<String,String> MyMap = new HashMap<>();
		MyMap.put("Maharashtra","Mumbai");
		MyMap.put("Gujrat","Gandhinager");
		MyMap.put("Punjab","Delhi");
		MyMap.put("Bihar","Mirzapur");
		Iterator<String> itr = MyMap.keySet().iterator();
		System.out.println("Iteration using while loop - ");
		while(itr.hasNext())
		{
			String key = itr.next();
			System.out.println("Key is "+key+"Value is "+MyMap.get(key));
		}
		System.out.println();
		System.out.println("Iteration using while loop - ");
		
		for (Map.Entry entry : MyMap.entrySet())
		{
			System.out.println("Key is: " + entry.getKey() + ", Value is: " + entry.getValue());
		}
                            

	}
}