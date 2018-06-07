<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Arithmetic Result</title>
</head>
<body>

<!-- request, session and application objects are available to us in the jsp implicitly. -->

<%-- <% 
Double result = (Double) session.getAttribute("result");
String error = (String) session.getAttribute("error");
String additionalInfo = (String) session.getAttribute("additionalInfo");
%> --%>

<jsp:useBean id="result" scope="session" class="com.karthik.model.ArithmeticResult"/>

<%-- <% if (!error.isEmpty()) { %>
	Error : <%= error %>
<% } else if (Math.floor(result) == result){ %>
	<%= !additionalInfo.isEmpty() ? additionalInfo : "" %>
	<br>
	Result is : <%= result.intValue() %>
<% } else { %>
	<%= !additionalInfo.isEmpty() ? additionalInfo : "" %>
	<br>
	Result is : <%= result %>
<% } %> --%>

<c:choose>
	<c:when test="${result.error != \"\" && result.error != null }">
		Error : <c:out value="${result.error}"></c:out>
	</c:when>
	
	<c:when test="${Math.floor(result.result) == result.result }">
		Result is <fmt:formatNumber maxFractionDigits="0" value="${result.result }"></fmt:formatNumber>
	</c:when>
	
	<c:otherwise>
		Result is <c:out value="${ result.result }"></c:out>
	</c:otherwise>
</c:choose>


<form action="${pageContext.request.contextPath}/logout" method="post">
    <input type="submit" value="Logout" />
</form>

</body>
</html>