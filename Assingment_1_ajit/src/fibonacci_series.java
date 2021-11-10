public class fibonacci_series
{
	public static void main(String args[]) 
	{
		int sum=0,a=0,b=1;
		for(int i=0;i<10;i++)
		{
			a=b;
			b=sum;
			sum=a+b;
			System.out.println(sum);
		}
	}
}