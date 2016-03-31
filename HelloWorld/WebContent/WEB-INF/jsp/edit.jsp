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
	<h2>Edit</h2>
	<h2>UserName : ${currentUser.username}</h2> 
	<form action="edit" method="post">
		<input type="hidden" name="id"> 
		<input type="hidden" name="username" value="${currentUser.username}">
		<br/>
		<label for="firstname">FirstName</label> 
		<input type="text" id="firstname" name="firstname" value="${currentUser.firstname }" /> 
		
		<label for="middlename">MiddleName</label> 
		<input type="text" id="middlename" name="middlename" value="${currentUser.middlename }" /> 
		
		<label for="lastname">LastName</label> 
		<input type="text" id="lastname" name="lastname" value="${currentUser.lastname }"/> 
		<br/>
		
		<label for="job">Job</label> 
		<input type="text" id="job" name="job" value="${currentUser.job }"/> 
		<br/>
		
		<label for="email">Email</label> 
		<input type="email" id="email" name="email" value="${currentUser.email }" /> 
		<br/>
		<label for="department">Department</label> 
		<input type="text" id="department" name="department" value="${currentUser.department }" /> 
		<br/>
		<input type="submit" value="Submit" />
	</form>
</body>
</html>