<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>

<%@page import="java.sql.PreparedStatement"%>
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
	
	//Class.forName("com.mysql.jdbc.Driver"); 
	Connection con = DriverManager.getConnection(url1, user, password);
	out.print("Success");
	out.println();
	
	
	String t1=request.getParameter("t1");
	String r1=request.getParameter("r1");
	String tamil=request.getParameter("tamil");
	String english=request.getParameter("english");
	String maths=request.getParameter("maths");
	String science=request.getParameter("science");
	String social_science=request.getParameter("social_science");
	String Total=request.getParameter("total");
	String average=request.getParameter("avg");
	String result=request.getParameter("result");
	
	out.println("aaaa");
	
	
	if(!t1.equals("") && !r1.equals("") && !tamil.equals("") && !english.equals("") && !maths.equals("") && !science.equals("") && !social_science.equals("") && !Total.equals("") && !average.equals("") && !result.equals(""))
	{
		PreparedStatement ps=con.prepareStatement("insert into student values(?,?,?,?,?,?,?,?,?,?)");
		
		ps.setString(1, t1);
		ps.setString(2, r1);
		ps.setString(3, tamil);
		ps.setString(4, english);
		ps.setString(5, maths);
		ps.setString(6, science);
		ps.setString(7, social_science);
		ps.setString(8, Total);
		ps.setString(9, average);
		ps.setString(10, result);
		
		int i=ps.executeUpdate();
		out.print(i);
		
		out.println("Data inserted successfully");
		
		
			
			
		}
	PreparedStatement ps=con.prepareStatement("select *from student");
	ResultSet rs=ps.executeQuery();
	
	out.print("<table border='1px'>");
	out.print("<tr>");
	out.print("<td>"+"Name"+"</td>");
	out.print("<td>"+"ROllno"+"</td>");
	out.print("<td>"+"Tamil"+"</td>");
	out.print("<td>"+"English"+"</td>");
	out.print("<td>"+"Maths"+"</td>");
	out.print("<td>"+"Science"+"</td>");
	out.print("<td>"+"Social"+"</td>");
	out.print("<td>"+"Total"+"</td>");
	out.print("<td>"+"Average"+"</td>");
	out.print("<td>"+"Result"+"</td>");
	
	while(rs.next())
	{
		String name=rs.getString(1);
		String rollno=rs.getString(2);
		String tam=rs.getString(3);
		String eng=rs.getString(4);
		String mat=rs.getString(5);
		String sci=rs.getString(6);
		String soc=rs.getString(7);
		String tot=rs.getString(8);
		String ave=rs.getString(9);
		String res=rs.getString(10);
		
		out.print("<tr>");
		out.print("<td>"+name+"</td>");
		out.print("<td>"+rollno+"</td>");
		out.print("<td>"+tam+"</td>");
		out.print("<td>"+eng+"</td>");
		out.print("<td>"+mat+"</td>");
		out.print("<td>"+sci+"</td>");
		out.print("<td>"+soc+"</td>");
		out.print("<td>"+tot+"</td>");
		out.print("<td>"+ave+"</td>");
		out.print("<td>"+res+"</td>");
		
	}
	out.print("</table>");
}

	catch(Exception e)
	{
		out.print(e);
	}


%>
</body>
</html>