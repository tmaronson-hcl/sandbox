<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Actors</title>
</head>
<body>
	first name:	<c:out value="${firstname}" /><br/>  
	last name:	<c:out value="${lastname}" /><br/>
	<h2>Employee Details</h2>
	<table border="1">
	  <tr>
		<th>Actor ID</th>
		<th>Actor First Name</th>
		<th>Actor Last Name</th>
		<th>Date</th>
	  </tr>

		<c:forEach items="${actors}" var="row">
			<tr>
				<td>${row[0]}</td>
				<td>${row[1]}</td>
				<td>${row[2]}</td>
				<td>${row[3]}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>