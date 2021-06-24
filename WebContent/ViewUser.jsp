<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
</head>
<body>
  <h1>Hello World!</h1>
  <form action="UpdateUser" method="post">
    <label for="">id</label>
    <input type="text" readonly value="<c:out value="${u.id}" />" >
    <label for="">name</label>
    <input type="text" name="name" value="<c:out value="${u.name}" />">
    <label for="">email</label>
    <input type="text" name="email" value="<c:out value="${u.email}" />">
    <input type="submit">
  </form>
</body>
</html>