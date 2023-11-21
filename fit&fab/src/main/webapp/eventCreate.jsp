<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Event</title>
</head>
<body>
	
	<form:form action="eventadd" modelAttribute="event1">
   	 	Event Name:<form:input path="event_name" />
		<br>
       	Description:<form:input path="description" />
		<br>
    	BranchManager:<form:input type="number" path="" name="bmid" placeholder="${bmid}"/>
		<br>
		<form:button>Save</form:button>
	</form:form>
</body>
</html>