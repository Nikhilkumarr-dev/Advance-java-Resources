<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="in.Nikhil.entity.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Success page</title>
</head>
<body>
	<h1 style='text-align:center;'>EMPLOYEE DATA</h1>
	<%
	Employee emp = (Employee) request.getAttribute("employee");
	%>
	<table border='1' align='center'>
		<tr>
			<th>EID</th>
			<th>ENAME</th>
			<th>EAGE</th>
			<th>EADRESS</th>
		</tr>
		<tr>
			<td><%=emp.getEid()%></td>
			<td><%=emp.getEname()%></td>
			<td><%=emp.getEage()%></td>
			<td><%=emp.getEadress()%></td>
			
		</tr>
	</table>
</body>
</html>