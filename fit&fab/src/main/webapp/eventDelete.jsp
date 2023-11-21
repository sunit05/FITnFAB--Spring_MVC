<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Event</title>
</head>
<body>
	${b}
	<form:form action="eventdelete">
   	 	Enter event id to Delete:<form:input path=""/>
		<br>
		<form:button>Delete</form:button>
	</form:form>
</body>
</html>