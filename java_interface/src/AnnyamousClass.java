interface Demo
{
	void show();
}
public class AnnyamousClass {

	public static void main(String[] args) {
		Demo d = new Demo() 
			{	
			public void show() {
				System.out.println("I am a example of annyamous class!!");
			}
		};
		
		d.show();
	}

}
