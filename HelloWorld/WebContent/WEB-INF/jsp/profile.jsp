<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Profile</h2>
	<a href="${currentUser.username}/edit">Edit</a>
	
	<br/>
	<label>Username: </label>
	<c:out value="${currentUser.username }"></c:out>
	<br/>
	<label>FullName: </label>
	<c:out value="${currentUser.fullname }"></c:out>
	<br/>
	<label>Job: </label>
	<c:out value="${currentUser.job }"></c:out>
	<br/>
	<label>Email: </label>
	<c:out value="${currentUser.email }"></c:out>
	<br/>
	<label>Deparment: </label>
	<c:out value="${currentUser.department }"></c:out>
	<br/>
</body>
</html>