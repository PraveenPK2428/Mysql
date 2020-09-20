import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class insert_data 
{
	String data()
	{
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the id");
		int Id=sc.nextInt();
		
		System.out.println("Enter the url");
		String url=sc.next();
		
		 System.out.println("Enter the localpath");
		 String localpath = sc.next();
		 			
		 System.out.println("Enter the status");
		 String status = sc.next();
		 String s = "insert into test values('"+Id+"','"+url+"','"+localpath+"','"+status+"')";
		 System.out.println("Data inserted successfully");
		
		return s;
		
	}

}




