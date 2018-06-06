<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Arithmetic Result</title>
</head>
<body>

<!-- request, session and application objects are available to us in the jsp implicitly. -->

<% 
Double result = (Double) session.getAttribute("result");
String error = (String) session.getAttribute("error");
String additionalInfo = (String) session.getAttribute("additionalInfo");
%>

<% if (!error.isEmpty()) { %>
	Error : <%= error %>
<% } else if (Math.floor(result) == result){ %>
	<%= !additionalInfo.isEmpty() ? additionalInfo : "" %>
	<br>
	Result is : <%= result.intValue() %>
<% } else { %>
	<%= !additionalInfo.isEmpty() ? additionalInfo : "" %>
	<br>
	Result is : <%= result %>
<% } %>


<a href="login.jsp">Logout</a>

</body>
</html>