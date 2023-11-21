<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Add Branch</h1>
	<form:form action="addBranch" modelAttribute="branch1">
   	 	Branch Code:<form:input path="branch_code"/><br>
       	City:<form:input path="city"/><br>
       	Address:<form:input path="address"/><br>
		<form:button>Save</form:button>
	</form:form>
</body>
</html>