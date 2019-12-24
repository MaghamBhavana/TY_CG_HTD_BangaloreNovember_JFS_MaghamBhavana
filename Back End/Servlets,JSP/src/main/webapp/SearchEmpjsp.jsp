<%@page import="com.capgemini.mywebapp.bean.EmployeeInfoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page session="false" %>
    <% EmployeeInfoBean employeeInfoBean = (EmployeeInfoBean)request.getAttribute("employeeInfoBean");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<fieldset>
		<legend>Search Employee</legend>
		<form action="./searchEmployee3" method="get">
			Employee ID:<input type="number" name="empId" required> <br>
			<input type="submit" value="Search">
		</form>
	</fieldset>
	<br>
	<br>
	<%if(employeeInfoBean==null) { %>
		<h3 style="color: black;">Employee Id not Found</h3>
		<%} else {%>
		<h3 style="color: navy;">Details For Employee Id <%=employeeInfoBean.getEmpId() %></h3><br>
		Employee Name = <%=employeeInfoBean.getName() %><br>
		Employee Age = <%=employeeInfoBean.getAge() %><br>
		Employee designation = <%=employeeInfoBean.getDesignation() %><br>
		Employee Salary = <%=employeeInfoBean.getSalary() %><br>
		<%} %>
</body>
</html>