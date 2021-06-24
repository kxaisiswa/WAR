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
		<c:forEach items="${user}" var="s">
			<tr>
				<td><c:out value="${s.id}" /></td>
				<td><c:out value="${s.name}" /></td>
				<td><c:out value="${s.email}" /></td>
				<td>
					<a href="UpdateSupplierServlet?id=<c:out value="${s.id}" />">Update</a>
					<a href="DeleteSupplierServlet?id=<c:out value="${s.id}" />">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>