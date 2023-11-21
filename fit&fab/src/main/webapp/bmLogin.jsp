<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Branch Manager Login </title>
</head>
<body>

<h1>${loginStatus}</h1>
	<form:form action="BmLogin" modelAttribute="loginBm">
   	 	email:<form:input path="email"/><br>
       	password:<form:password path="password"/><br>
		<form:button>login</form:button>
		<a href="createBm">register branch manager </a>
	</form:form>

</body>
</html>