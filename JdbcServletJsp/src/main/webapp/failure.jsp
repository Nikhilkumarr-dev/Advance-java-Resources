<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>failure page</title>
</head>
<body>
	<h1 style='color:red; text-align:center'>
	Record not available for the given id::
	<%=request.getAttribute("userId") %>
	</h1>
</body>
</html>