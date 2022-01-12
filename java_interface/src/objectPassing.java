import java.sql.*;
import com.mysql.*;

public class objectPassing {

	int a = 5;

	static void changeValue(objectPassing o) {
		o.a++;
	}

	public static void main(String[] args) throws Exception {
		objectPassing t = new objectPassing();
		System.out.println(t.a);
		changeValue(t);
		System.out.println(t.a);
		
		Object k = new objectPassing();
		
		//System.out.println(k.a); ---> we cant use object directly. we have to pass the object to to reference vaiable through typecasting as follows.
		objectPassing m = (objectPassing)k;
		System.out.println(m.a);
	}

}
