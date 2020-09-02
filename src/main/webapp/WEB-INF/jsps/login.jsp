<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" href="<c:url value="/resources/css/loginstyle.css" />" >
</head>
<body>
	<s:form modelAttribute="user" action="login" cssClass="position-center">
		<h1>Login</h1>
		<s:hidden path="user_id"/>
		
		<s:label path="user_email" cssClass="label" >Email</s:label>
		<s:input path="user_email" cssClass="input" /><br/>
		<s:errors path="user_email" cssClass="error" /><br/>
		
		<s:label path="user_pw" cssClass="label">Password</s:label>
		<s:input path="user_pw" cssClass="input"/><br/>
		<s:errors path="user_pw" cssClass="error" /><br/>
		
		<input type="submit" value="Login" class="button"/><br />
	</s:form>
</body>
</html>