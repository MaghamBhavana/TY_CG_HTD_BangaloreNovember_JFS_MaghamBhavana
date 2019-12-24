<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page session="false" %>
    <%String msg = (String) request.getAttribute("msg"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3 style="color: red;"><a href="./home">Home</a></h3>
	<fieldset>
		<legend>Update Employee</legend>
		<form action="./updateEmpJsp2" method="post">
			<table>
				<tr>
					<td>Employee Id</td>
					<td>:</td>
					<td><input type="number" name="empId" required="required">
				</tr>
				<tr>
					<td>Employee Name</td>
					<td>:</td>
					<td><input type="text" name="name" >
				</tr>
				<tr>
					<td>Age</td>
					<td>:</td>
					<td><input type="number" name="age" >
				</tr>
				<tr>
					<td>Salary</td>
					<td>:</td>
					<td><input type="number" name="salary" >
				</tr>
				<tr>
					<td>Designation</td>
					<td>:</td>
					<td><input type="text" name="designation" >
				</tr>
				<tr>
					<td>Password</td>
					<td>:</td>
					<td><input type="password" name="password" >
				</tr>
				<tr>
					<td colspan="3" align="center"><br> <input type="submit"
						value="submit">
				</tr>
			</table>
		</form>
	</fieldset>
	<% if( msg != null && !msg.isEmpty()) { %>
	<h3 style="color: red;"><%=msg %></h3>
	<%} %>
</body>
</html>