import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Down
{
	 Connection conn;

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
			Statement st = conn.createStatement();
			insert_data b=new insert_data();
			String a=b.data();
			
			st.executeUpdate(a);
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
		
	}
}
    

	