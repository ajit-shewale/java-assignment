class Demo1 {
	public static int a = 10;
	public static int b = 20;

}

public class FieldHiding extends Demo1 {
	public static int a = 30;

	public static void main(String[] args) {
		System.out.println(a);
		System.out.println(b);

	}

}
