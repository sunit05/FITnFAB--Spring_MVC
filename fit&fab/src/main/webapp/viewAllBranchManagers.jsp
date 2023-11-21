<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of Branch Managers </title>
</head>
<body>


	<table border="1" style="border-collapse: collapse;">

		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Email</th>
			<th>Status</th>
			<th>Authorize</th>
		</tr>

		<c:forEach var="s" items="${bms}">
			<tr>
			<td>${s.getId()}</td>
			<td>${s.getName()}</td>
			<td>${s.getEmail()}</td>
			<td>${s.getStatus()}</td>
			<td><a href="authorize?id=${s.getId()}">Authorize</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>