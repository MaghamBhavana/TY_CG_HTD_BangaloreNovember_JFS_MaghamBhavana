<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<% String msg = (String) request.getAttribute("msg"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<fieldset>
		<legend>Delete Employee</legend>
		<form action="./deleteEmployee2" method="get">
			Employee Id:<input type="number" name="empId" required="required"><br>
			<input type="submit" value="Delete">
		</form>
	</fieldset>
	<% if (msg != null && !msg.isEmpty()) { %>
	<h3 style="color: red;"><%=msg%></h3>
	<% } %>
</body>
</html>