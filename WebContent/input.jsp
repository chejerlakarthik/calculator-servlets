<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Arithmetic Operations</title>
</head>
<body>

	<form action="app/ArithmeticServlet" method="post">
		
		Operation: <select name="operation">
			<option value="ADD">ADD</option>
			<option value="SUB">SUB</option>
			<option value="MUL">MUL</option>
			<option value="DIV">DIV</option>
		</select> 
		<br /> <br /> 
		
		Operand 1: <input type="text" name="operand1" /> 
		<br /> <br /> 
		
		Operand 2: <input type="text" name="operand2" /> 
		<br /> <br /> 
		
		<input type="submit" name="Submit" />
	</form>

</body>
</html>