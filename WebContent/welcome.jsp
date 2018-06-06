<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.karthik.model.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Refresh" content="${delay};url=${nextPage}">
<title>Welcome</title>
</head>
<body>

<jsp:useBean id="user" class="com.karthik.model.User" scope="request"/>

Welcome <jsp:getProperty property="fullName" name="user"/>, you are now authenticated !! <br> <br>

Redirecting to ${nextPage} in ${delay} seconds...

</body>
</html>