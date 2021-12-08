public class Prorigo
{
	public static void main(String args[])
	{
		String name = "Prorigo"; // taking a string for prorigo.
		int sizeOfName = name.length(); // taking length of string/

		for (int i = 0; i < sizeOfName; i++) {
			for (int j = 0; j <= i; j++) //
			{
				System.out.print(name.charAt(j)); // printing letter by letter.
			}
			System.out.println();
		}
	}
}