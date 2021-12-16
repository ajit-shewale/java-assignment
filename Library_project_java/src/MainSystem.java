import java.util.Scanner;

public class MainSystem {
	static Library lib = new Library();
	static Scanner sc = new Scanner(System.in);

	public static void main(String args[]) {
		int choice;
		do {
			System.out.print("\n###___MENU___###");
			System.out.print("\n1.Show the Library");
			System.out.print("\n2.Add Book");
			System.out.print("\n3.Remove Book");
			System.out.print("\n4.Issue a Book");
			System.out.print("\n5.Return Book");
			System.out.print("\n0.EXIT");
			System.out.print("\nEnter your choice : ");
			choice = sc.nextInt();
			System.out.println("--------------------------");

			switch (choice) {
			case 1:
				lib.showLibrary();
				break;
			case 2:
				lib.addBook();
				break;
			case 3:
				lib.removeBook();
				break;
			case 4:
				lib.issueBook();
				break;
			case 5:
				lib.returnBook();
				break;
			case 0:
				System.out.println("----------Thank you----------");
				break;
			default:
				System.out.println("Invalid Choice !!");
				break;
			}
		} while (choice != 0);
	}
}