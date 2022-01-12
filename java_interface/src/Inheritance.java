class Vehicle
{
	int tyers;
	String colour;
	double speed;
	
	void show(Vehicle v)
	{
		System.out.println(v.tyers+" "+v.colour+" "+v.speed);
	}
}

 class Car extends Vehicle
{
	void makeCar(int tyers,String colour,double speed)
	{
		this.tyers=tyers;
		this.colour=colour;
		this.speed=speed;
	}
}
public class Inheritance {

	public static void main(String[] args) {

		Car car1 = new Car();
		car1.makeCar(4,"yellow",200.00);
		car1.show(car1);
	}

}
