<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>   

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script>

function calculate()
{
var Tamil=document.getElementById('tamil').value;
var English=document.getElementById('english').value;
var Maths=document.getElementById('maths').value;
var Science=document.getElementById('science').value;
var Social_Science=document.getElementById('social_science').value;

var Total=parseInt(Tamil)+parseInt(English)+parseInt(Maths)+parseInt(Science)+parseInt(Social_Science);
var tot=document.getElementById('total');
tot.value=Total;

var Average=(parseInt(Tamil)+parseInt(English)+parseInt(Maths)+parseInt(Science)+parseInt(Social_Science))/5;
var ave=document.getElementById('avg');
ave.value=Average;

if(Tamil>=35 && English>=35 && Maths>=35 && Science>=35 && Social_Science>=35)
{
var res="Pass";
var Result=document.getElementById('result');
Result.value=res;
}
else
{
var res="Fail";
var Result=document.getElementById('result');
Result.value=res;
}
}
function clr()
{
document.getElementById("t1").value = "";
document.getElementById('r1').value = "";
document.getElementById('tamil').value = "";
document.getElementById('english').value = "";
document.getElementById('maths').value = "";
document.getElementById('science').value = "";
document.getElementById('social_science').value = "";
document.getElementById('total').value = "";
document.getElementById('avg').value = "";
document.getElementById('result').value = "";
}
</script>
</head>
<body>
<form action="details_student.jsp" method="post" >
<table>

<tr>
<th>Name:</th>
<td><input type="text" name="t1" id="t1" placeholder="Enter name"></td>
</tr>

<tr>
<th>Reg No:</th>
<td><input type="text"  name="r1" id="r1" ></td>
</tr>

<tr>
<th>Tamil:</th>
<td><input type="text" name="tamil" id="tamil" ></td>
</tr>


<tr>
<th>English:</th>
<td><input type="text" name="english" id="english" ></td>
</tr>

<tr>
<th>Maths:</th>
<td><input type="text" name="maths" id="maths" ></td>
</tr>

<tr>
<th>Science:</th>
<td><input type="text" name="science" id="science" ></td>
</tr>

<tr>
<th>Social Science:</th>
<td><input type="text" name="social_science" id="social_science" ></td>
</tr>

<tr>
<th>Total:</th>
<td><input type="text" name="total" id="total"  ></td>
</tr>

<tr>
<th>Average:</th>
<td><input type="text" name="avg" id="avg" ></td>
</tr>

<tr>
<th>Result:</th>
<td><input type="text" name="result" id="result"></td>
</tr>

<tr>

<td><input type="Button" value="Calculate" onclick="calculate()"></td>

<td><input type="Button" value="clear" onclick="clr()" ></td>
</tr>
<tr>

<td><input type="submit" value="submit">
</tr>
</table>
</form>
<br>
<br>


</body>
</html>