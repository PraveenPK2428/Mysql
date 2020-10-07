import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;



public class Downld_Vw 
{
	 Connection conn;
	 
      ArrayList<String> ar=new ArrayList<String>();	         
	 

		public static void main(String[] args) 
	{
			Downld_Vw dd=new Downld_Vw();
			
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
			 System.out.println("Id"+" "+"File_name"+"     "+"url"+" "+"     "+"Localpath"+"  "+"  "+" Status"+" ");

		
			//---------EXECUTE DATA--------------------
            ResultSet res = mystmt.executeQuery(strsql);
            
          

           while(res.next())
            {
        	   dd.ar.add(res.getString(1));
        	   dd.ar.add(res.getString(2));
        	   dd.ar.add(res.getString(3));
        	   dd.ar.add(res.getString(4));
        	   dd.ar.add(res.getString(5));
        	  
            }
           
           res.close();
		
		//	conn.close(); 
					
		}
		catch(Exception e)
		{
            System.out.println(e);
        }	
		
		System.out.println("---------------------------------------------");
		
		int i=0;
		
		for(String ab:dd.ar)
		{
			
			System.out.print(ab+"    ");
		
			i++;
			if(i==5)
			{
				System.out.println();
				i=0;
			}	
		}
		
		System.out.println("Enter Any One ID Num To View File");
		Scanner sc=new Scanner(System.in);
		
		int id=sc.nextInt();
		
		
		int indx=dd.ar.indexOf(Integer.toString(id));
		System.out.println(dd.ar.get(indx+1));
		System.out.println(dd.ar.get(indx+2));
		System.out.println(dd.ar.get(indx+3));
		System.out.println(dd.ar.get(indx+4));
		
		Scanner a1=new Scanner(System.in);
		System.out.println("Enter the file name");
		String b=a1.next();
		
		File fi = new File("E://"+b);
	
		try 
		
		{
			FileInputStream fis = new FileInputStream(fi);
 			int content;
			while ((content = fis.read())!= -1) 
			{
				
				System.out.print((char) content);
			} 
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}



    

	