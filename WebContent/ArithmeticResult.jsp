<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Arithmetic Result</title>
</head>
<body>

<% 
Double result = (Double) session.getAttribute("result");
String error = (String) session.getAttribute("error");
%>

<% if (!error.isEmpty()) { %>
	Error : <%= error %>
<% } else if (Math.floor(result) == result){ %>
	Result is : <%= result.intValue() %>
<% } else { %>
	Result is : <%= result %>
<% } %>

</body>
</html>