<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GUEST LIST</title>
<link rel="stylesheet" href="<c:url value="/resources/css/liststyle.css" />" >
</head>
<body class="list">
		<h1>Guest Lists</h1>
		<table class="list-table">
			<tr>
				<th>Name</th>
				<th>Email</th>
				<th>Password</th>
				<th>Phone</th>
				<th>Country</th>
				<th>Actions</th>
			</tr>

			<c:forEach var="e" items="${listofguests}" >
			
				<c:url var="deleteLink" value="/deleteUser">
					<c:param name="userId" value="${e.user_id}" />
				</c:url>
				
				<c:url var="updateLink" value="/editUser">
					<c:param name="userId" value="${e.user_id}" />
				</c:url>
				
				<tr>
					<td>${e.user_name}</td>
					<td>${e.user_email}</td>
					<td>${e.user_pw}</td>
					<td>${e.user_phone}</td>
					<td>${e.user_country}</td>
					<td><a href="${updateLink}">Update</a> <a href="${deleteLink}"
						onclick="if(!(confirm('Are you sure you want to delete '))) return false;">
							Delete</a></td>
				</tr>
			</c:forEach>
		</table>
</body>
</html>