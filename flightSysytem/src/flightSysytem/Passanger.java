package flightSysytem;

public class Passanger {
	private int checkBags;
	private int freeBags;
	private double perBagFee;
	
	public int getCheckBags() {
		return checkBags;
	}
	public void setCheckBags(int checkBags) {
		this.checkBags = checkBags;
	}
	public int getFreeBags() {
		return freeBags;
	}
	public void setFreeBags(int freeBags) {
		this.freeBags = freeBags;
	}
	
	public  Passanger(int freeBags){
		this(freeBags > 1 ? 25.0d : 50.0d);
		this.freeBags = freeBags;
	}
	public Passanger(int freeBags, int checkBags)
	{
		this(freeBags);
		this.checkBags =checkBags;
	}
	
	private Passanger(double perBagFee){
		this.perBagFee = perBagFee;
	}
}
