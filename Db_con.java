package praveen;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Db_Conn 
{
	Connection con;
	PreparedStatement ps;
    Db_Conn()
   {

   try
   {
	   String db_Name="java";
	    con = DriverManager.getConnection("jdbc:mysql://localhost/"+db_Name+"","root","");

	   System.out.println("Success");
   }
   catch(Exception e)
   {
	   System.out.println(e);
   }
   }
   public void insData(String name,String phone)
   {
	   try
	   {
		  
		   ps=con.prepareStatement("insert into contact values(?,?)");
		   ps.setString(1,name);
		   ps.setString(2,phone);
		   int i=ps.executeUpdate();
		   System.out.println(i);
	   }
	   catch(Exception e)
	   {
		   System.out.println(e);
	   }
   }
   public void retData()
   {
	   try
	   {
		   ps=con.prepareStatement("select * from contact");
		   ResultSet rs=ps.executeQuery();
		   
		   while(rs.next())
		   {
			   System.out.println(rs.getString(1));
			   System.out.println(rs.getString(2));
		   }
		   
	   }
	   catch(Exception e)
	   {
		   System.out.println(e);
	   }
   }
   public void updData()
   {
	   try
	   {
		   ps=con.prepareStatement("update contact set fname=? where phone=?");
		   ps.setString(1,"Vijay");
		   ps.setString(2,"12345");
		   //ps.setString(2,b);
		   int i=ps.executeUpdate();
		   System.out.println(i);
	   }
	   catch(Exception e)
	   {
		   System.out.println(e);
	   }
   }
   public void delData()
   {
	   try
	   {
		   ps=con.prepareStatement("delete from contact where fname=?");
		   ps.setString(1,"vijay");
		   
		   //ps.setString(2,b);
		   int i=ps.executeUpdate();
		   System.out.println(i);
	   }
	   catch(Exception e)
	   {
		   System.out.println(e);
	   }
   }

	public static void main(String[] args) 
	{
	
		Db_Conn dd=new Db_Conn();
		dd.insData("PK","55555");
		//dd.retData();
		//dd.updData();
		//dd.delData();
	}

}
