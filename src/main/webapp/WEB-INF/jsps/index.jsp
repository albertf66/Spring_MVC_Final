<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Online Renting</title>
<link rel="stylesheet"
	href="<c:url value="/resources/css/liststyle.css" />">
</head>
<body>
	
	<h1>Online Renting</h1>
	<div class="list-2">
	<table class="list-table">
		
		<tr>
			<th>Home</th>
			<c:url var="edit" value="/editUserforGuest">
					<c:param name="userEmail" >${userEmail}</c:param>
			</c:url>
			<th></th>
			<th><a href="${edit}" >Edit</a></th>
		</tr>
		<tr>
			<th>
				<img alt="room1" src="/SpringMVCFinal/resources/images/room1.jpeg">
				<h2>Room 1</h2>
				<h4>Price : RMB 2,000/night</h4>
			</th>
			<th>
				<img alt="room2" src="/SpringMVCFinal/resources/images/room2.jpeg">
				<h2>Room 2</h2>
				<h4>Price : RMB 2,300/night</h4>
			</th>
			<th>
				<img alt="room3" src="/SpringMVCFinal/resources/images/room3.jpeg">
				<h2>Room 3</h2>
				<h4>Price : RMB 4,000/night</h4>
			</th>
		</tr>
		<tr>
			<th>
				<img alt="room4" src="/SpringMVCFinal/resources/images/room4.jpeg">
				<h2>Room 4</h2>
				<h4>Price : RMB 2,000/night</h4>
			</th>
			<th>
				<img alt="room5" src="/SpringMVCFinal/resources/images/room5.jpeg">
				<h2>Room 5</h2>
				<h4>Price : RMB 3,000/night</h4>
			</th>
			<th>
				<img alt="room6" src="/SpringMVCFinal/resources/images/room6.jpeg">
				<h2>Room 6</h2>
				<h4>Price : RMB 1,500/night</h4>
			</th>
		</tr>
	</table>
	</div>
</body>
</html>