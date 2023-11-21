<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View all events</title>
</head>
<body>


	<table border="1" style="border-collapse: collapse;">

		<tr>
			<th>ID</th>
			<th>EVENT Name</th>
			<th>EVENT DESCRIPTION</th>
			<th>BY MANAGER</th>
			<th>Delete</th>
			
		</tr>

		<c:forEach var="s" items="${event}">
			<tr>
			<td>${s.getId()}</td>
			<td>${s.getEvent_name()}</td>
			<td>${s.getDescription()}</td>
			<td>${s.getBranchManager().getId()}</td>
			<td><a href="delete?eventid=${s.getId()}">delete</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>