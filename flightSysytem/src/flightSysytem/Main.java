package flightSysytem;

public class Main{
	public static void main(String args[])
	{
		Flight flight1 = new Flight();
		Flight flight2 = new Flight();
		
		flight2.add1Passanger();
		System.out.println("flight2 passangers = "+flight2.passangers);
		
		flight2 = flight1;
		System.out.println("flight2 passangers = "+flight2.passangers);
		
		flight1.add1Passanger();
		flight1.add1Passanger();
		System.out.println("flight2 passangers = "+flight2.passangers);
	}
}
