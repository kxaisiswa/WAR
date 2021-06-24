<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
 table, td, th {
 	border: 1px solid black;
 	border-collapse: collapse;
 }
</style>
</head>
<body>
	<table>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Email</th>
		</tr>
		<c:forEach items="${user}" var="u">
			<tr>
				<td><c:out value="${u.id}" /></td>
				<td><c:out value="${u.name}" /></td>
				<td><c:out value="${u.email}" /></td>
				<td>
					<a href="UpdateUser?id=<c:out value="${u.id}" />">Update</a>
					<a href="DeleteUser?id=<c:out value="${u.id}" />">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>