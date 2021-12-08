import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class QueueDemo
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		Queue q  =  new LinkedList<>();
		System.out.println("Enter a queue of 10 elements - ");
		for(int i=0;i<10;i++)
		{
			q.offer(sc.nextInt());
		}
		System.out.println("Entered Queue - ");
		System.out.println(q);
		System.out.println("Show first element - ");
		System.out.println(q.peek());
		System.out.println("Remove first element ");
		System.out.println(q.poll());
		System.out.println("Queue after removing head element -");
		System.out.println(q);
		
		
	}
}