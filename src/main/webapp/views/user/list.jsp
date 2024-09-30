<%@page import="models.User"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
	width: 100%;
	border-collapse: collapse;
}

table td, table th {
	padding: 8px;
	border: 1px solid #ddd;
	text-align: center;
}

h1 {
	text-align: center;
}
</style>
</head>

<div align="center">
	<h1>User Management</h1>
	<h2>
		<a href="${pageContext.request.contextPath}/users?action=new">Add
			New User</a> &nbsp;&nbsp;&nbsp; <a
			href="${pageContext.request.contextPath}/users">List All Users</a>
	</h2>
	<h2>List Users</h2>
	<table>
		<tr>
			<th>ID</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Password</th>
			<th>Birthday</th>
			<th>Gender</th>
			<th>Management</th>
		</tr>
		<c:forEach var="user" items="${listUser}">
			<tr>
				<td><c:out value="${user.id}" /></td>
				<td><c:out value="${user.firstName}" /></td>
				<td><c:out value="${user.lastName}" /></td>
				<td><c:out value="${user.email}" /></td>
				<td><c:out value="${user.password}" /></td>
				<td>
					<%
					Object obj = pageContext.findAttribute("user");
					User user = (User) obj;
					LocalDate birthday = user.getBirthDay();
					String formattedDate = birthday.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
					out.print(formattedDate);
					%>
				</td>

				<td><c:out value="${user.gender}" /></td>
				<td><a
					href="${pageContext.request.contextPath}/users?action=edit&id=<c:out value='${user.id}' />">Edit</a>
					<a
					href="${pageContext.request.contextPath}/users?action=delete&id=<c:out value='${user.id}' />">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>