public class Prorigo
{
	public static void main(String args[])
	{
		String name = "Prorigo" ; 
		int n = name.length();
		
		for(int i=0; i<=n; i++)
		{
			for(int j=0; j<=i;j++)
			{
				System.out.print(name.charAt(j));
			}
			System.out.println();
		}
	}
}