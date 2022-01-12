interface ajit {
	void add();
}

interface mayur extends ajit {
	void sub();
}

public class ExtendingInterface implements mayur {

	@Override
	public void add() {
		int a = 20, b = 10;
		int c = a + b;
		System.out.println("a+b = " + c);
	}

	@Override
	public void sub() {
		int a = 20, b = 10;
		int c = a - b;
		System.out.println("a-b = " + c);
	}

	public static void main(String[] args) {
		mayur k = new ExtendingInterface();
		k.add();
		k.sub();

	}

}
