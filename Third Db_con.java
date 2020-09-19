package javaprogram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;



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

			System.out.println("connected Successfully");
		}
		catch(Exception e)
		   {
			   System.out.println(e);
			   throw new NullPointerException();
		   }
	 }
		   public void insData(String url,String localpath)
		   {
			   try
			   {
				   ps=con.prepareStatement("select * from downloader set url=? where localpath=?");
				   ps.setString(1,url);
				   ps.setString(2,localpath);
				   int i=ps.executeUpdate();
				   System.out.println(i);
			   }
			   catch(Exception e)
			   {
				   System.out.println(e);
				   System.out.println("insert successfully");

			   }
		   }
		  
		    public void download(String status)
		   {
			   try
			   {
				   ps=con.prepareStatement("upadate the downloader where status=?");
				   ps.setString(3,status);
				   Boolean completed = true;

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
				   System.out.println("status successfully");

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
						   System.out.println(rs.getString(3));
					   }
					   
				   }
				   catch(Exception e)
				   {
					   System.out.println(e);
					   System.out.println("Ret data successfully");

				   }
			   }
			   public void updData()
			   {
				   try
				   {
					   ps=con.prepareStatement("update downloader set url=? where localpath=?");
					  ps.setString(1,"www.google.com");
					  ps.setString(2,"localstorage");
					  
					   int i=ps.executeUpdate();
					   System.out.println(i);
				   }
				   catch(Exception e)
				   {
					   System.out.println(e);
					   System.out.println("update successfully");

				   }
			   }
			   public void delData()
			   {
				   try
				   {
					   ps=con.prepareStatement("delete from downloader where url=?");
					   ps.setString(1,"www.unknown.com");
					   
					   int i=ps.executeUpdate();
					   System.out.println(i);
				   }
				   catch(Exception e)
				   {
					   System.out.println(e);
					   System.out.println("delete successfully");

				   }
			   }


	public static void main(String[] args) 
	{
		
		Db_con dd=new Db_con ();
		dd.insData("url data","location");
		
		//dd.retData();
		//dd.updData();
		//dd.delData();
		//dd.download("complete");
	}
	
	}




