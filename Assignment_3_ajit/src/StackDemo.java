import java.util.Scanner;
import java.util.Stack;
import java.util.Iterator;
class StackDemo
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		Stack<Integer> stack=new Stack<>();
		//System.out.println("Push the elemnet to the stack");
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		
		System.out.println("Stack Elements - ");
		System.out.println(stack);
		
		int poped=stack.pop();
		System.out.println("Poped Element - "+poped);
		System.out.println("Stack Elements - ");
		System.out.println(stack);
		System.out.println("Search a Element in Stack - ");
		int element=sc.nextInt();
		int index=stack.search(element);
		System.out.println("The ele found is :"+index);
		System.out.println("Size of Stack - "+stack.size());
		
		boolean result=stack.empty();
		System.out.println("Stack is empty - "+result);
		System.out.println("The stack is traversal using iterator :");
		Iterator itr=stack.iterator();
		while(itr.hasNext())
		{
		Object ele=itr.next();
		System.out.println(ele);
		}
		System.out.println("enter the position whose ele you want");
		int position=sc.nextInt();
		System.out.println("The element at  position is :"+stack.get(position));
		
		System.out.println("The Top element in stack is : "+stack.peek());
	}
}