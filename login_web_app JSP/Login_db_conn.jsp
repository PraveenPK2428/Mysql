
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
try
{
	String url1 = "jdbc:mysql://localhost/java";
	String user = "root";
	String password = "";
	
	Class.forName("com.mysql.jdbc.Driver"); 
	Connection con = DriverManager.getConnection(url1, user, password);
	out.print("Success");
	out.println(); 
	
	String t1=request.getParameter("t1");
	String pswd=request.getParameter("pswd");
	
	
	if(!t1.equals("") && !pswd.equals(""))
	{
		PreparedStatement ps=con.prepareStatement("insert into login values(?,?)");
		ps.setString(1, t1);
		ps.setString(2,pswd);
		
		int i=ps.executeUpdate();
		out.print(i);
		
		out.println("Data inserted successfully");
		
	}
}
catch(Exception e)
{
	out.print(e);
}
	%>


</body>
</html>