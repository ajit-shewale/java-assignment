import java.util.ArrayList;
import java.util.Scanner;
import java.util.Scanner;
import java.sql.*;
import com.mysql.*;

public class Library {
	Scanner sc = new Scanner(System.in);
	ArrayList<Book> bookCollection = new ArrayList<>();
	public String url = "jdbc:mysql://localhost:3306/library_schema";
	public String user = "root";
	public String password = "PSPL@1234";

	public void addBook() {
		System.out.println("\nId:");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("\nTitle:");
		String title = sc.nextLine();
		System.out.println("\nAuthor:");
		String author = sc.nextLine();
		System.out.println("\nPrice:");
		double cost = sc.nextDouble();
		System.out.print("\nQuantity:");
		int quantity = sc.nextInt();

		try {
			Connection con = DriverManager.getConnection(url, user, password);
			Statement st = con.createStatement();
			String sql = "insert into  library_schema.library_table (Book_id,Title,Author,Cost,Quantity)values(?,?,?,?,?);";
			PreparedStatement preparedStmt = con.prepareStatement(sql);
			preparedStmt.setInt(1, id);
			preparedStmt.setString(2, title);
			preparedStmt.setString(3, author);
			preparedStmt.setDouble(4, cost);
			preparedStmt.setInt(5, quantity);
			preparedStmt.execute();
			System.out.println("Inserted Successfully!!");
		} catch (Exception e) {
			System.out.println("!!__Connection failed__!!");
		}
	}

	public void removeBook() {
		System.out.print("Enter book id:");
		int id = sc.nextInt();
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			Statement st = con.createStatement();
			String sql = "delete from library_schema.library_table where Book_id = (?);";
			PreparedStatement preparedStmt = con.prepareStatement(sql);
			preparedStmt.setInt(1, id);
			preparedStmt.execute();
			System.out.println("Deleted Successfully!!");
		} catch (Exception e) {
			System.out.println("!!__Connection failed__!!");
		}

	}

	public void showLibrary() throws ClassNotFoundException, SQLException {
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM library_schema.library_table;");
			while (rs.next()) {
				System.out.println("ID= " + rs.getInt("Book_id") + "  Title= " + rs.getString("Title") + "  Author= "
						+ rs.getString("Author") + "  Cost= " + rs.getString("Cost") + "  Quantity= "
						+ rs.getInt("Quantity"));
				System.out.println();
			}

		} catch (Exception e) {
			System.out.println("!!__Connection failed__!!");
		}
	}

	public void issueBook() {
		System.out.println("Enter Your id:");
		int cust_id = sc.nextInt();
		System.out.print("Enter book id:");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.print("\nEnter your Name -  ");
		String name = sc.nextLine();

		try {
			Connection con = DriverManager.getConnection(url, user, password);
			Statement st = con.createStatement();
			String sql = "insert into  library_schema.issued_book(Cust_id,Book_id,Student_name,Issued_date,Expiry_date)values(?,?,?,CURDATE(),CURDATE());";
			PreparedStatement preparedStmt = con.prepareStatement(sql);
			preparedStmt.setInt(1, cust_id);
			preparedStmt.setInt(2, id);
			preparedStmt.setString(3, name);
			preparedStmt.execute();
			System.out.println("Issued Successfully!!");
		} catch (Exception e) {
			System.out.println("!!__Connection failed__!!");
		}
	}

	public void returnBook() {
		System.out.print("Enter your id:");
		int cust_id = sc.nextInt();
		System.out.print("Enter book id:");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.print("\nEnter your Name -  ");
		String name = sc.nextLine();
		System.out.print("\nEnter Book Name -  ");
		String title = sc.nextLine();

		try {
			Connection con = DriverManager.getConnection(url, user, password);
			Statement st = con.createStatement();
			String sql = "insert into  library_schema.return_books(Cust_id,Book_id,Stu_name,Title)values(?,?,?,?);";
			PreparedStatement preparedStmt = con.prepareStatement(sql);
			preparedStmt.setInt(1,cust_id);
			preparedStmt.setInt(2,id);
			preparedStmt.setString(3,name);
			preparedStmt.setString(4,title);
			preparedStmt.execute();
			System.out.println("Issued Successfully!!");
		} catch (Exception e) {
			System.out.println("!!__Connection failed__!!");
		}
	}
}