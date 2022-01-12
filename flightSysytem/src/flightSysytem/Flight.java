package flightSysytem;

public class Flight {

	private int passangers;
	private int seats;
	
	public int getSeats() {
		return seats;
	}
	
	public void setSeats(int seats) {
		this.seats = seats;
	}

	public Flight() {
		passangers = 0;
		seats = 150;
	}

	public void add1Passanger(){
		if(passangers < seats)
		{
			passangers = passangers+1;
		}
		else
		{
			handaleTooMany(); 
		}
	 }
		private void handaleTooMany() {
			System.out.println("Too many passangers!!");
		}
	}
	
	
	
}
