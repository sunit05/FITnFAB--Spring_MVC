<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of Branches </title>
</head>
<body>


	<table border="1" style="border-collapse: collapse;">

		<tr>
			<th>ID</th>
			<th>Branch Code</th>
			<th>Address</th>
			<th>City</th>
			<th>Delete</th>
			
		</tr>

		<c:forEach var="s" items="${branch}">
			<tr>
			<td>${s.getId()}</td>
			<td>${s.getBranch_code()}</td>
			<td>${s.getAddress()}</td>
			<td>${s.getCity()}</td>
			<td><a href="delete?id=${s.getId()}">delete</a></td>
			
			</tr>
		</c:forEach>
	</table>

</body>
</html>