<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page session="false" %>
    <%String msg= (String) request.getAttribute("msg"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2 style="color: blue;"><a href="./home">Home</a></h2>
<fieldset>
		<legend>Add Employee</legend>
		<form action="./addEmployee2" method="post">
			<table>
				<tr>
					<td>Employee Id</td>
					<td>:</td>
					<td><input type="number" name="empId" required="required">
				</tr>
				<tr>
					<td>Employee Name</td>
					<td>:</td>
					<td><input type="text" name="name" required="required">
				</tr>
				<tr>
					<td>Age</td>
					<td>:</td>
					<td><input type="number" name="age" required="required">
				</tr>
				<tr>
					<td>Salary</td>
					<td>:</td>
					<td><input type="number" name="salary" required="required">
				</tr>
				<tr>
					<td>Designation</td>
					<td>:</td>
					<td><input type="text" name="designation" required="required">
				</tr>
				<tr>
					<td>Password</td>
					<td>:</td>
					<td><input type="password" name="password" required="required">
				</tr>
				<tr>
					<td colspan="3" align="center"><br> <input type="submit"
						value="add">
				</tr>
			</table>
		</form>
	</fieldset>
	<% if(msg != null && !msg.isEmpty()) { %>
	<h3 style="color: navy;"><%=msg %></h3>
	<% } %>
</body>
</html>