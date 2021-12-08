public class fibonacci_series
{
	public static void main(String args[])
	{
		int  sum=0,a = 0, b = 1;
		System.out.println("Fibonacci Series upto 10 - ");
		for (int i = 1; i < 10; i++) {
			System.out.println(sum);
			sum = a + b;
			a = b;
			b = sum;
		}
	}
}

