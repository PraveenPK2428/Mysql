package javaprogram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class Db_con 
{
	Connection con;
	PreparedStatement ps;
	public Db_con()
	{
		try
		{
			   String db_Name="java";

			//Class.forName("com.mysql.jdbc.Driver");
			//DriverManager.getConnection("jdbc:mysql://localhost:3306/downloader" +
            //        "user=root & password=root");
			DriverManager.getConnection("jdbc:mysql://localhost/"+db_Name+"","root","");

			System.out.println("Success");
		}
		catch(Exception e)
		   {
			   System.out.println(e);
		   }
	 }
		   public void insData(String url,String localpath)
		   {
			   try
			   {
				   ps=con.prepareStatement("insert into values(?,?)");
				   ps.setString(1,url);
				   ps.setString(2,localpath);
				   int i=ps.executeUpdate();
				   System.out.println(i);
			   }
			   catch(Exception e)
			   {
				   System.out.println(e);
			   }
		   }
		  
		   
		   public void status()
		   {
			   try
			   {
				  
				   
				   boolean completed = true;

				   if ( completed ) {
				       System.out.println("download completed");
				   } else {
				       System.out.println("download incomplete");
				   }
				  
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
					   ps=con.prepareStatement("select * from downloader");
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
					   ps=con.prepareStatement("update contact set url=? where localpath=?");
					  // ps.setString(1,"Vijay");
					  // ps.setString(2,"12345");
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
					   ps=con.prepareStatement("delete from contact where url=?");
					   //ps.setString(1,"vijay");
					   
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
		
		Db_con dd=new Db_con ();
		//dd.insData("PK","55555");
		
		//dd.retData();
		//dd.updData();
		//dd.delData();
		 //dd.status();

	}

}
