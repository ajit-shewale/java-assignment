import java.util.HashMap;
class CountNoWords

{
	public static void main(String args[])
	{
		int j=0;
		String str="Fear leads to anger ; anger leads to hatred ; hatred leads to conflict ; conflict leads to suffering";
		HashMap<String,Integer> map=new HashMap<>();
		String[] string=str.split(" ");
		int n=string.length;
		String[] str2=new String[n];
		for(int i=0;i<n;i++)
		{
				if(string[i].equals(";")||string[i].equals(" ")||string[i].equals(".")||string[i].equals(","))
				{
					i++;
				}
				else
				{
					str2[j]=string[i];
					j++;
				}
		}

		for(String str1:str2)
		{
			 if(map.containsKey(str1))
			{
				 map.put(str1,map.get(str1)+1);
			}
			else
			{
				map.put(str1,1);
			}
		}

		System.out.println("word count - "+map);

}
}
