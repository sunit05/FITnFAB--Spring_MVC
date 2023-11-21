<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Branch Manger Registration</title>
</head>
<body>
	<h1>Create Branch Manager!</h1>
	<form:form action="bmadd" modelAttribute="bm1">
    Name:<form:input path="name" />
		<br>
    Email:<form:input path="email" />
		<br>
	Password:<form:password path="password" />
		<br>
		<form:button>Save</form:button>
	</form:form>
</body>
</html>
