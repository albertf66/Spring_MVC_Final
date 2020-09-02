<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editing</title>
<link rel="stylesheet" href="<c:url value="/resources/css/loginstyle.css" />" >
</head>
<body>
 	<s:form modelAttribute="user" action="editInfo" cssClass="position-center">
		
		<s:hidden path="user_id"/>
		
		<h1>Edit Info</h1>
		<s:label path="user_name" cssClass="label">Username</s:label>
		<s:input path="user_name" cssClass="input"/><br/>
		<s:errors path="user_name" cssClass="error" /><br/>
		
		<s:label path="user_email" cssClass="label" >Email</s:label>
		<s:input path="user_email" cssClass="input" /><br/>
		<s:errors path="user_email" cssClass="error" /><br/>
		
		<s:label path="user_pw" cssClass="label">Password</s:label>
		<s:input path="user_pw" cssClass="input"/><br/>
		<s:errors path="user_pw" cssClass="error" /><br/>
		
		<s:label path="user_phone" cssClass="label">Phone</s:label>
		<s:input path="user_phone" cssClass="input"/><br/>
		<s:errors path="user_phone" cssClass="error" /><br/>
		
		<s:label path="user_country" cssClass="label">Country</s:label>
		<s:select path="user_country" cssClass="input">
			<s:option value="India">India</s:option>
			<s:option value="Indonesia">Indonesia</s:option>
			<s:option value="China">China</s:option>
		</s:select>
		<br/>
		
		<input type="submit" class="button" value="Save Data"/> <br/>
		
		<br/> <br/>
	</s:form>
	
</body>
</html>