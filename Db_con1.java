import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Down
{
	 
	  
	/* public void insdata() 
	 {
		 try
		 {
	 
		 
		 Scanner sc=new Scanner(System.in);
		 ps=conn.prepareStatement("select * from test set id =? ,url=?, localpath=? where status=?");
			System.out.println("Enter the url");
			String url=sc.next();
			
			 System.out.println("Enter the localpath");
			 String localpath = sc.next();
			 			
			 System.out.println("Enter the status");
			 String status = sc.next();
			 
			 ps.executeUpdate("insert into test values ('"+url+"','"+localpath+"','"+status+"')");
			 System.out.println("Data inserted successfully");
		 }
		 catch(Exception e)
		   {
			   System.out.println(e);
			   
		   }
	 }
*/
	 
	
		public static void main(String[] args) 
	{
			
			
		
		String dbname = "java";
		String url1 = "jdbc:mysql://localhost/java";
		String user = "root";
		String password = "";
		
		System.out.println("connected successfully");
		try
		{
			// 1. Get a connection to database
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url1, user, password);
		
				
			// 2. Create a statement
			Statement mystmt = conn.createStatement();
			String strsql = "SELECT * FROM Test";
			
			// 3. Execute SQL query
			// Adding insert data from the input user
			Scanner sc=new Scanner(System.in);
			
			Statement st = conn.createStatement();
			System.out.println("Enter the id");
			int Id=sc.nextInt();
			
			System.out.println("Enter the url");
			String url=sc.next();
			
			 System.out.println("Enter the localpath");
			 String localpath = sc.next();
			 			
			 System.out.println("Enter the status");
			 String status = sc.next();
			 String s = "insert into test values('"+Id+"','"+url+"','"+localpath+"','"+status+"')";
			 st.executeUpdate(s);
			 System.out.println("Data inserted successfully");
			
		/*	//--------Update data in the database-----------------
			String updatequery = "update test set url = 'www.fb.com'" + "where id = 2";
			mystmt.executeUpdate(updatequery);
			System.out.println("Update Successfully");   */
			
		/*//--------Delete the data in the database--------------
			String deletequery = "delete from test where id=10";
			int rowsAffected = mystmt.executeUpdate(deletequery);
			System.out.println("RowsAffected: "+""+rowsAffected);
			System.out.println("deleted successfully"); */
			
			//---------Execute data--------------------
         /*   ResultSet res = mystmt.executeQuery(strsql);

           while(res.next())
            {
                System.out.println("id :"+res.getString(1));
                System.out.println("url :"+res.getString(2));
                System.out.println("Localpath :"+res.getString(3));
                System.out.println("Status :"+res.getString(4));
            }
            res.close();
           
			conn.close(); */
			
			
			
		}
		catch(Exception e)
		{
            System.out.println(e);
        }	
		//Down dd=new Down();
		//dd.insdata();
		//System.out.println("Insert data successfully");
	}
}
    

	