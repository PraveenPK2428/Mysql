<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
th,td{
padding:10px;
}

</style>
</head>
<body>
<center>
<form action="Login_db_conn.jsp" method="post">
<h1 style="padding:20px">Welcome to the Login</h1>
<table>
<tr>
<tr>
<th>Email:</th>
<td><input type="text" name="t1" id="t1" placeholder="Enter the name"></td>
</tr>

<tr>
<th>Password:</th>
<td><input type="password" name="pswd" id="pswd"></td>
</tr>
</table>
<center>
<input type="submit" onclick="press()">
</center>
</form>
</center>


</body>
</html>